// Imports
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_10084_XMLParser_A08 {

    public static void main(String[] args) {

        // Step 1: Initialize DocumentBuilderFactory and DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 2: Use DocumentBuilder to parse XML
        try {
            Document doc = builder.parse("sample.xml"); // load the XML document

            // Step 3: Handle the XML document using a SecurityManager
            doc.getDocumentElement().normalize();
            System.out.println(doc.getDocumentElement().getNodeName());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}