package example1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLInteratorReader {
	public static void main(String[] args) {
		XMLInputFactory inputFactory = XMLInputFactory.newFactory();
		try {
			XMLEventReader eventReader = inputFactory.createXMLEventReader(new FileInputStream(new File("/Users/KAI/servjsp/Session4/src/example1/ccinfo.xml")));
			while(eventReader.hasNext()){
			 XMLEvent event =	eventReader.nextEvent();
			 if(event.isStartElement()){
				 StartElement element = (StartElement)event;
				 System.out.println("===Start Element Local Name: "+ element.getName());
				 Iterator<Attribute> iterator = element.getAttributes();
				 while(iterator.hasNext()){
					 Attribute attribute = (Attribute)iterator.next();
					 System.out.println("===Attribute value: "+ attribute.getValue());
				 }
				 
			 }
			 if(event.isEndElement()){
				 EndElement element = (EndElement)event;
				 System.out.println("===End Element Local Name: "+ element.getName());
				 
			 }
			 
			 if(event.isCharacters()){
				 Characters characters = (Characters)event;
				 System.out.println("===Characters Value: "+ characters.getData());	
				 System.out.println("===Characters Event Type: "+ characters.getEventType());	
				 
			 }
			 
			 if(event.isStartDocument()){
				 StartDocument document = (StartDocument)event;
				 System.out.println("===Document Version: "+ document.getVersion());
				 System.out.println("===Document Version: "+ document.getCharacterEncodingScheme());
			 }
			 
			 if(event.isEndDocument()){
				 System.out.println("End Document");
				 eventReader.close();
			 }
			 
			}
		
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		} 
	}
}	
