package example1;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReadDataQuery {
	public static void main(String[] args) {
		File outputFile = new File("/Users/KAI/servjsp/Session4/src/example1/OutputPayInfo.xml");
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document doc = builder.parse(new FileInputStream(outputFile));
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("PayInfo-Output");
			Node node = nodeList.item(0);
			Element element = (Element)node;
			String query = element.getElementsByTagName("SelectStmnt").item(0).getTextContent();
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/test_db", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			generateDom(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void generateDom(ResultSet rs) throws SQLException {
		while(rs.next()){
			System.out.println("=====resultSet : "+ rs.getString(1));
		}
		
	}
}
