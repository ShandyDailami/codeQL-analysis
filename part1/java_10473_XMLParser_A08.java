import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_10473_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse("sample.xml"); // sample.xml is a XML file located in your classpath

            // TODO: Process the XML document here. 
            // Here you can use the DOM (Document Object Model) to interact with the XML data.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}