import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_33485_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document document = builder.parse("example.xml");

            // Process the document here.
            // For example, print out all the element names and values.
            document.getDocumentElement().normalize();
            System.out.println("Root Element: " + document.getDocumentElement().getNodeName());

            // Iterate over the child elements of the root element
            for (int i = 0; i < document.getDocumentElement().getChildNodes().getLength(); i++) {
                System.out.println("Child Element " + (i + 1) + ": " + document.getDocumentElement().getChildNodes().item(i).getNodeName());
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}