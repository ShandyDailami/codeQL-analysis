import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_29002_XMLParser_A03 {

    public static void main(String[] args) {
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Create a DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Create a new File object for the XML file
        File file = new File("sample.xml");

        // Parse the XML file
        Document document = builder.parse(file);

        // Print out the parsed XML
        System.out.println(document.getDocumentElement().getNodeName());
    }
}