import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_11689_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Print the parsed information
            doc.getElementsByTagName("node").item(0).getTextContent();

            // Security-sensitive operations related to A08_IntegrityFailure
            // Here, we are going to replace the node value with an empty string
            doc.getElementsByTagName("node").item(0).setTextContent("");

            // Save the modified document
            doc.getDomConfig().normalizeDocument();
            dBuilder.setOutgoingProperty("omit-xml-declaration", "true");
            dBuilder.save(new File("modified.xml"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}