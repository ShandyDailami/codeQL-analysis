import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_37860_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("input.xml"));

            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("A08_IntegrityFailure");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element node = (Element) nodes.item(i);

                // Handle integrity failure nodes here
                // For example, print the integrity failure node's name
                System.out.println("IntegrityFailure: " + node.getAttribute("name"));
            }
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}