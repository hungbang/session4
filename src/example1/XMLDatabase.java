package example1;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.events.Attribute;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLDatabase {
	public static void main(String[] args) {
		File file = new File("/Users/KAI/servjsp/Session4/src/example1/ccinfo.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document doc = builder.parse(new FileInputStream(file));
			doc.getDocumentElement().normalize();
			System.out.println("====Root Node: " + doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("PayInfo");
			// connection
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/test_db", "root", "root");
			Statement statement = connection.createStatement();
			String sqlString = "insert into PayInfo(Name, Number,Issuer, Expiration, Limitabc, Currency) "
					+ "values(?,?,?,?,?,?);";
			PreparedStatement ps = connection.prepareStatement(sqlString);

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					ps.setString(1, element.getElementsByTagName("Name").item(0).getTextContent());
					ps.setString(2, element.getElementsByTagName("Number").item(0).getTextContent());
					ps.setString(3, element.getElementsByTagName("Issuer").item(0).getTextContent());
					ps.setString(4, element.getElementsByTagName("Expiration").item(0).getTextContent());
					ps.setString(5, element.getElementsByTagName("CreditCard").item(0).getAttributes().getNamedItem("Limit").getTextContent());
					ps.setString(6, element.getElementsByTagName("CreditCard").item(0).getAttributes().getNamedItem("Currency").getTextContent());
					ps.execute();
				}
			}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
