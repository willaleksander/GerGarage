package ie.cct.gergarage.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ie.cct.gergarage.model.NumberType;
import ie.cct.gergarage.model.Token;
import ie.cct.gergarage.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins = "*")
public class GerGarageController {
	private String SECRET_KEY = "secret";

	private List<User> users;

	public GerGarageController() {
		users = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
			String line = "";
			while((line = br.readLine()) != null) {
				String [] user = line.split(" ");
				users.add(new User(user[0], user[1]));
			}
			br.close();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
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
	
	@PostMapping("/login")
	public Token login(@RequestBody User loggingUser) {
		
		try {
            Connection connection = (Connection) DriverManager.getConnection(
            		"jdbc:mysql://localhost:3306/gergarage", "root", "password");

            PreparedStatement st = (PreparedStatement) connection
                .prepareStatement("SELECT username, password FROM user WHERE username=? and password=?");

            st.setString(1, loggingUser.getUsername());
            st.setString(2, loggingUser.getPassword());
            
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
            	return createJWT("finalproject", loggingUser.getUsername(), "gergarage");
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
