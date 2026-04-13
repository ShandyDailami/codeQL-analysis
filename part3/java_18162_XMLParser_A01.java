import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_18162_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for handling the XML parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for handling the XML document
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document document = builder.parse("input.xml");

            // TODO: handle the document here, for example print the document's tag names
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}