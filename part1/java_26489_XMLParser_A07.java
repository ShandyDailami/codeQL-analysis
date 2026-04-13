import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_26489_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("input.xml"); // Path to your XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Process the XML document here
            // For example, print all element names and attributes
            doc.getElementsByTagName("*").item(0).getNodeName();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}