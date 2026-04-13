import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_08035_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Step 1: Initialize DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse("src/test.xml");

            // Step 4: (Optional) Print out the parsed document
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElements().get(0).getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}