import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_20963_XMLParser_A07 {

    public static void main(String[] args) {
        // Create DocumentBuilderFactory and DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Use DocumentBuilder to parse XML from file
        Document document = builder.parse(new File("sample.xml"));

        // Get root element
        document.getDocumentElement().normalize();

        // Print all element names
        printElementNames(document);
    }

    private static void printElementNames(Document document) {
        // Get all elements in the document
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Element : " + nodeList.item(i).getNodeName());
        }
    }
}