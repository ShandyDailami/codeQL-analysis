import java.net.URL;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_05810_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com/sample.xml"); // provide a valid URL
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(url.openStream());

            String tagName = "employee"; // replace with the actual tag name
            List<String> attributeNames = List.of("id", "name", "age"); // replace with the actual attribute names

            parseXML(doc, tagName, attributeNames);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXML(Document doc, String tagName, List<String> attributeNames) {
        NodeList nodes = doc.getElementsByTagName(tagName);

        for (int i = 0; i < nodes.getLength(); i++) {
            String attributeValue = "";

            for (String attributeName : attributeNames) {
                attributeValue += doc.getElementsByTagName(attributeName).item(i).getTextContent() + " ";
            }

            System.out.println("Employee " + (i + 1) + ": " + attributeValue);
        }
    }
}