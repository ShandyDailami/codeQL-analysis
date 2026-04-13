import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03478_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "data.xml"; // Your XML file path

        try {
            // Create a factory for the DocumentBuilder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Use factory to build a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file into a Document object
            Document doc = dBuilder.parse(xmlFile);

            // Print the parsed document
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElements().get(0).getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}