import java.io.FileInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_23468_XMLParser_A08 {
    public static void main(String[] args) {
        String fileName = "sample.xml";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;

        try (FileInputStream fis = new FileInputStream(fileName)) {
            document = builder.parse(fis);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        // Here you can process the document, for example, print all element names or values.
        document.getDocumentElement().getElementsByTagName("*").forEach(node -> {
            System.out.println("Node name: " + node.getNodeName());
            System.out.println("Node value: " + node.getTextContent());
        });
    }
}