import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_14986_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml"; // replace with your xml file path
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);

            // process XML document
            // this is a very basic example, you would normally want to iterate through the elements
            doc.getDocumentElement().getFirstChildElement().normalize();

        } catch (SAXException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}