import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34750_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse("path_to_your_xml_file.xml");

            // Here you can perform operations with the XML document

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}