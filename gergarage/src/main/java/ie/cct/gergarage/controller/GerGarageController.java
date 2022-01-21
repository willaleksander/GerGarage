package ie.cct.gergarage.controller;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ie.cct.gergarage.model.Make;
import ie.cct.gergarage.model.Model;
import ie.cct.gergarage.model.NumberType;
import ie.cct.gergarage.model.Token;
import ie.cct.gergarage.model.User;
import ie.cct.gergarage.repository.MakeRepository;
import ie.cct.gergarage.repository.ModelRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins = "*")
public class GerGarageController {
	private String SECRET_KEY = "secret";

	@Autowired
	private MakeRepository makeRepository;
	@Autowired
	private ModelRepository modelRepository;
	
	public GerGarageController() {
		
        
           
        /*  
        Model model1=new Model("Focus", make1);
        Model model2=new Model("Ka", make1);
        Model model3=new Model("Uno", make2);
        Model model4=new Model("Palio", make2);
        Model model5=new Model("Toro", make2);
          */

		
	}
	
	@GetMapping(path="/allMake")
	  public @ResponseBody Iterable<Make> getAllMakes() {
	    // This returns a JSON or XML with the users
		Make make1=new Make("Ford");           
        Make make2=new Make("Fiat");
        
        makeRepository.save(make1);
        makeRepository.save(make2);
        
	    return makeRepository.findAll();
	  }
	@GetMapping(path="/allModel")
		  public @ResponseBody Iterable<Make> getAllModels() {
		    // This returns a JSON or XML with the users
		  Optional<Make> make1 = makeRepository.findById(1);
		  Optional<Make> make2 = makeRepository.findById(2);
	      
	      Model model1=new Model("Focus", make1.get());
	      Model model2=new Model("Ka", make1.get());
	      Model model3=new Model("Uno", make2.get());
	      Model model4=new Model("Palio", make2.get());
	      Model model5=new Model("Toro", make2.get());
	      
	      modelRepository.save(model1);
	      modelRepository.save(model2);
	      modelRepository.save(model3);
	      modelRepository.save(model4);
	      modelRepository.save(model5);
      
	    return makeRepository.findAll();
	  }
	

	@GetMapping("number-odd-even")
	public NumberType oddEven(@RequestParam("number") Integer number, @RequestHeader("Authorization") String auth) {
		try {
			String token = auth.split(" ")[1];
			verifyToken(token);
			if (number % 2 == 0) {
				NumberType test =  new NumberType("even");
				return test;
			}
			return new NumberType("odd");
		} catch (Exception e) {
			throw new RuntimeException("Unauthorized");
		}
	}

	private Token createJWT(String id, String subject, String issuer) throws UnsupportedEncodingException {
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] apiKeySecretBytes = SECRET_KEY.getBytes();
		
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signatureAlgorithm, SECRET_KEY.getBytes("UTF-8"));
		
		// https://github.com/oktadev/okta-java-jwt-example/blob/master/src/main/java/com/okta/createverifytokens/JWTDemo.java
		// Here shows how to add expiration.
		return new Token(builder.compact());
	}
	private Claims verifyToken(String token) {
		  Claims claims = Jwts.parser()
	                .setSigningKey(SECRET_KEY.getBytes())
	                .parseClaimsJws(token).getBody();
	        return claims;
	}
	
	@PostMapping("/login-test")
	public Token login(@RequestBody User loggingUser) {
		
		try {
            Connection connection = (Connection) DriverManager.getConnection(
            		"jdbc:mysql://localhost:3306/gergarage", "root", "password");

            PreparedStatement st = (PreparedStatement) connection
                .prepareStatement("SELECT user_username, user_password FROM user WHERE user_username=? and user_password=?");

            st.setString(1, loggingUser.getUser_username());
            st.setString(2, loggingUser.getUser_password());
            
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            	return createJWT("finalproject", loggingUser.getUser_username(), "gergarage");
            } else {
            	// TODO Needs a concrete exception
        		throw new RuntimeException("User not found");
            }
        } catch (SQLException | UnsupportedEncodingException sqlException) {
            sqlException.printStackTrace();
        }
		// TODO Needs a concrete exception
		throw new RuntimeException("User not found");
	}
}
