import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_37446_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            // Parse the XML file
            Document document = builder.parse(new File("path_to_your_xml_file.xml"));

            // Find all 'name' and 'age' nodes
            NodeList nameNodes = document.getElementsByTagName("name");
            NodeList ageNodes = document.getElementsByTagName("age");

            // Print 'name' and 'age' nodes
            for (int i = 0; i < nameNodes.getLength(); i++) {
                System.out.println("Name: " + nameNodes.item(i).getTextContent());
                System.out.println("Age: " + ageNodes.item(i).getTextContent());
            }

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}