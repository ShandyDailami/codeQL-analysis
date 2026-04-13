import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_33922_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Setup the DocumentBuilder for the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document document = builder.parse(new File("sample.xml"));

            // Step 4: Do some operations on the parsed XML document
            // You can use the DOM (Document Object Model) API of Java to manipulate the XML document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}