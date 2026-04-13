import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_35519_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("test.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            List<String> tags = List.of("tag1", "tag2", "tag3"); // Replace with your tags

            for (String tag : tags) {
                extractTagValues(doc, tag);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void extractTagValues(Document doc, String tag) {
        NodeList nodes = doc.getElementsByTagName(tag);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Value for tag " + tag + " in node " + (i+1) + ": " + node.getTextContent());
        }
    }
}