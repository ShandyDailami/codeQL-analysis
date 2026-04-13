import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_38650_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml"; // replace with your XML file path
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);

            // perform security-sensitive operations related to A01_BrokenAccessControl here

            // for example, print all element names
            document.getElementsByTagName("*").item(0).getNodeName();

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}