import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_36047_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for handling the document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for handling the document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new File("data.xml"));

            // Get the root element
            Element root = doc.getDocumentElement();

            // Get all "person" elements
            NodeList persons = root.getElementsByTagName("person");

            // Process each person
            for (int i = 0; i < persons.getLength(); i++) {
                Element person = (Element) persons.item(i);
                String name = person.getElementsByTagName("name").item(0).getTextContent();
                String age = person.getElementsByTagName("age").item(0).getTextContent();
                System.out.println("Person " + (i+1) + ": Name = " + name + ", Age = " + age);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}