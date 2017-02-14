package example1;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class AppRun {
	public static void main(String[] args) {

		  Customer customer = new Customer();
		  customer.setId(100);
		  customer.setName("mkyong");
		  customer.setAge(29);

		  try {

			File file = new File("/Users/KAI/servjsp/Session4/src/example1/file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(customer, file);
			jaxbMarshaller.marshal(customer, System.out);

		      } catch (JAXBException e) {
			e.printStackTrace();
		      }

		}
}
