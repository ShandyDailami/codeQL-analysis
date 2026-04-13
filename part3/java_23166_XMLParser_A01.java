import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_23166_XMLParser_A01 {

    public static void main(String[] args) {
        parseXmlFile("sample.xml");
    }

    private static void parseXmlFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File(fileName));
            System.out.println("Document parsed successfully.");

            // You can use the DOM API to manipulate the parsed XML document.
            // For example, you can select elements and print their text content.
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            System.out.println("CDATA section: " + doc.getDocumentElement().getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }
}