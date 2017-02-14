package example1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLDocumentReader {
	public static void main(String[] args) {
		File input = new File("/Users/KAI/servjsp/Session4/src/example1/ccinfo.xml");
		XMLInputFactory inputFactory = XMLInputFactory.newFactory();
		try {
			XMLStreamReader reader = inputFactory.createXMLStreamReader(new FileInputStream(input));
			while(reader.hasNext()){
				int eventType = reader.getEventType();
				switch (eventType) {
				case 1:
					System.out.println("Event Type: - START ELEMENT(1)");
					System.out.println("Start Element Name: "+ reader.getLocalName());
					break;
				case 2:
					System.out.println("Event Type: - END ELEMENT(2)");
					System.out.println("End Element Name: "+ reader.getLocalName());
					break;	
				case 3:
					System.out.println("Event Type: - Processing Instruction(3)");
					System.out.println("Processing Instruction Data: "+ reader.getPIData());
					break;	
				case 4:
					System.out.println("Event Type: - Character(4)");
					System.out.println("Characters Data: "+ reader.getText());
					break;		
				case 5:
					System.out.println("Event Type: - Comment(5)");
					System.out.println("Comment Data: "+ reader.getText());
					break;	
				case 6:
					System.out.println("Event Type: - Space(6)");
					System.out.println("Space Info: "+ reader.getText());
					break;	
				case 7:
					System.out.println("Event Type: - Start Document(7)");
					System.out.println("Encoding is: "+ reader.getCharacterEncodingScheme());
					System.out.println("Version is: "+ reader.getVersion());
					break;	
				
				}
				reader.next();
			}
			int eventType = reader.getEventType();
			if(eventType == 8){
				System.out.println("Event Type: - End Document(8)");
				reader.close();
			}
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		} 
	}
}
