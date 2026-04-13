import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_13927_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Read the XML file
            Document doc = builder.parse(new File("input.xml"));

            // Get the elements
            NodeList nodes = doc.getElementsByTagName("*");

            // Print the content of each element
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Element " + (i + 1) + ": " + nodes.item(i).getTextContent());
            }

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}