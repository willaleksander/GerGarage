package ie.cct.gergarage.model;

public class NumberType {

	private String type2;
	private String test;

	public NumberType() {
	}

	public NumberType(String type) {
		this.type2 = type;
		this.test = "teste";
	}

	public String getType() {
		return type2;
	}

	public void setType(String type) {
		this.type2 = type;
	}
}
