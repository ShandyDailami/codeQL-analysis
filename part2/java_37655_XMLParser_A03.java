import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_37655_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a factory for the parser
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create the document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            InputStream inputStream = new FileInputStream("input.xml");
            Document doc = builder.parse(inputStream);

            // Print the parsed XML
            System.out.println(doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}