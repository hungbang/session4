package example1;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XMLDocumentWriter {
	public static void main(String[] args) {
		XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
		try {
			XMLStreamWriter documentWriter = outputFactory.createXMLStreamWriter(new FileWriter("/Users/KAI/servjsp/Session4/src/example1/output.xml"));
			
			documentWriter.writeStartDocument("UTF-8", "1.0");
			documentWriter.writeComment("Dang test day");
			documentWriter.writeStartElement("PayInfo");
			
			documentWriter.writeStartElement("Name");
			documentWriter.writeCharacters("Vietcombank");
			documentWriter.writeEndElement();
			documentWriter.writeStartElement("CreditCard");
			documentWriter.writeAttribute("limit", "500");
			documentWriter.writeAttribute("Currency", "USD");
			documentWriter.writeEndElement();
			documentWriter.writeEndDocument();
			documentWriter.flush();
			documentWriter.close();
			
		} catch (XMLStreamException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
