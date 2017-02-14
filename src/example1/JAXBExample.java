package example1;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBExample {

	public static void main(String[] args) {

		 try {

			File file = new File("/Users/KAI/servjsp/Session4/src/example1/ccinfo.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(PayInfo.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			PayInfo payInfo = (PayInfo) jaxbUnmarshaller.unmarshal(file);
			System.out.println(payInfo);

		  } catch (JAXBException e) {
			e.printStackTrace();
		  }

		}

}
