import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_39431_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a Document
            Document doc = builder.parse(new File("sample.xml"));

            // Get all the elements
            NodeList nodeList = doc.getElementsByTagName("element");

            // Do some security-sensitive operations
            for (int i = 0; i < nodeList.getLength(); i++) {
                // ...
            }

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}