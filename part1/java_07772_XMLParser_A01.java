import java.util.List;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_07772_XMLParser_A01 {
    private static final String XML_FILE_PATH = "path_to_your_xml_file";

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(XmlParser.class.getResourceAsStream(XML_FILE_PATH));

        document.getElementsByTagName("node").forEach(node -> {
            String value = node.getTextContent();

            // Security-sensitive operation: Access control
            // Here, we assume we are dealing with passwords and we are storing them in the value variable.
            // This is a placeholder and does not represent a real-world security issue.
            // You should replace this with your actual security-sensitive operation.
            System.out.println("Password: " + value);
        });
    }
}