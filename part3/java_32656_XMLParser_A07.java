import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_32656_XMLParser_A07 {
    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document doc = dBuilder.parse("authFailure.xml");

            // Here, we are just printing the XML document to the console
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElements().get(0).getNodeName());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}