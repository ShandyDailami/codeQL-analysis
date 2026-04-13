import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35875_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Your code to manipulate the XML document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}