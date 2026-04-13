import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_15054_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load the document using the builder
            Document doc = builder.parse("input.xml");

            // Start your injection code here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}