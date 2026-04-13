import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_39939_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFile = "src/main/resources/brokenAccessControl.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Here you can add the code to handle the XML document.
            // For example, you can print the document's root element.
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}