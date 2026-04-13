import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21781_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder using the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input XML file into a Document object
            Document doc = builder.parse("input.xml");

            // Extract and print data
            String data = doc.getElements().getItem(0).getChildNodes().getItem(0).getNodeValue();
            System.out.println(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}