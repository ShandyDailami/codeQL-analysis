import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_33532_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            // Create a factory for building a new DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to construct a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Use the builder to parse the input XML file
            Document doc = builder.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("example.xml"));

            // TODO: Handle the parsed document here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}