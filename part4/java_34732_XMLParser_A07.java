import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_34732_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse("resources/example.xml");

            // Get all elements
            NodeList nodes = doc.getElementsByTagName("*");

            // Print out the content of each element
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Element " + (i+1) + ": " + nodes.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}