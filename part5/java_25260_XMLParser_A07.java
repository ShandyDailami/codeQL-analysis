import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_25260_XMLParser_A07 {

    public static void main(String[] args) {

        try {
            // Create a factory for reading XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a new builder for handling XML
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse("authfailure.xml");

            // Handle the document
            XmlParser parser = new XmlParser(doc);
            parser.parseDocument();

        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}