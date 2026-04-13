import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27149_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Create a factory for handling the XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a builder for handling the XML
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML document
            Document document = builder.parse("path_to_your_xml_file.xml");

            // TODO: Handle the document here.
            // You may need to authenticate the document here and if
            // the document is authenticated successfully, you may want to
            // continue processing it, otherwise, you may want to report
            // the auth failure.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}