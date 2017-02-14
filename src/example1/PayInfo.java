package example1;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PayInfo")
public class PayInfo {
	private String Name;
	private String CreditCard;
	private String Number;
	private String Issuer;
	private String Expiration;
	private String Limit;
	private String Currency;
	
	public String getName() {
		return Name;
	}
	@XmlElement(name="Name")
	public void setName(String name) {
		Name = name;
	}
	public String getCreditCard() {
		return CreditCard;
	}
	@XmlElement(name="CreditCard")
	public void setCreditCard(String creditCard) {
		CreditCard = creditCard;
	}
	public String getNumber() {
		return Number;
	}
	
	@XmlElement(name="Number")
	public void setNumber(String number) {
		Number = number;
	}
	public String getIssuer() {
		return Issuer;
	}
	
	@XmlElement(name="Issuer")
	public void setIssuer(String issuer) {
		Issuer = issuer;
	}
	
	public String getExpiration() {
		return Expiration;
	}
	
	@XmlElement(name="Expiration")
	public void setExpiration(String expiration) {
		Expiration = expiration;
	}
	public String getLimit() {
		return Limit;
	}
	
	@XmlAttribute(name="Limit")
	public void setLimit(String limit) {
		Limit = limit;
	}
	public String getCurrency() {
		return Currency;
	}
	
	@XmlAttribute(name="Currency")
	public void setCurrency(String currency) {
		Currency = currency;
	}
	
	@Override
	public String toString() {
		return "Name: "+ Name + "===CreditCard: "+ CreditCard + "===Number: "+ Number + "====Expiration: " + Expiration;
	}
	
}
