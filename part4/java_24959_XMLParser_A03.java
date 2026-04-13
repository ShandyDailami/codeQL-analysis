import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_24959_XMLParser_A03 {

    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML from the URL
        Document doc = builder.parse("http://example.com/sample.xml");

        // Here you can add your code to manipulate the parsed XML
        // For instance, you can get the value of a specific element
        String elementValue = doc.getElementsByTagName("elementName").item(0).getTextContent();

        System.out.println("Element value: " + elementValue);
    }
}