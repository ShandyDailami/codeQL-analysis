import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_33394_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // step 1: setting up DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(true);
            factory.setFeature("http://xml.org/sax/features/namespaces", true);
            factory.setFeature("http://xml.org/sax/features/namespaces", false);

            // step 2: getting a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // step 3: parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Here you can do your parsing operations, e.g., extracting elements
            // or attributes of the XML document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}