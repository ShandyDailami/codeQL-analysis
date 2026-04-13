import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34551_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse("test.xml");

            // Print the document elements
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            // Print the first child element of the root element
            System.out.println("First child element: " + doc.getDocumentElement().getChildNodes().item(0).getNodeName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}