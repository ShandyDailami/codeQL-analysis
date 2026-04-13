import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_42033_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            // Load the XML document
            URL url = new URL("http://example.com/test.xml"); // replace with your URL
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            // Get all element names
            NodeList nodes = doc.getElementsByTagName("*");
            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Element: " + nodes.item(i).getNodeName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}