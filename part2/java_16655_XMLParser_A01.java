import java.io.File;
import java.io.IOException;
import java.security.AccessControlException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_16655_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            // Load XML file
            File xmlFile = new File("src/main/resources/people.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Get all 'person' elements
            NodeList personList = doc.getElementsByTagName("person");

            for (int i = 0; i < personList.getLength(); i++) {
                Document personDoc = personList.item(i).getDocumentElement();
                String name = personDoc.getElementsByTagName("name").item(0).getTextContent();
                String age = personDoc.getElementsByTagName("age").item(0).getTextContent();

                System.out.println("Person: " + name + ", Age: " + age);
            }

        } catch (AccessControlException | ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

}