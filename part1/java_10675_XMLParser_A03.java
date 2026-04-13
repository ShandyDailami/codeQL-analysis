import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_10675_XMLParser_A03 {

    public static void parse(String xmlFilePath) throws Exception {
        // Create a factory for building DOM tree
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a builder for handling XML document
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse the XML file and create a DOM tree model from it
        Document document = builder.parse(xmlFilePath);

        // TODO: Security-sensitive operations related to A03_Injection

        // Print out the parsed XML
        document.getDocumentElement().normalize();
        System.out.println("Root element: " + document.getDocumentElement().getNodeName());
    }

    public static void main(String[] args) throws Exception {
        parse("example.xml");
    }
}