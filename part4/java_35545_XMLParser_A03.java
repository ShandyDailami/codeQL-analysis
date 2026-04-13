import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35545_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Load XML document
            Document document = builder.parse("input.xml");

            // TODO: Add your security-sensitive operations related to A03_Injection

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}