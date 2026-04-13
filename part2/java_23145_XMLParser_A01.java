import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_23145_XMLParser_A01 {
    private static final String XML_FILE_PATH = "path/to/your/xml/file.xml"; // replace with your XML file path
    private static final String TARGET_TAG = "target_tag"; // replace with your target tag

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File(XML_FILE_PATH));
            doc.getDoctype();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        startParsing(doc, TARGET_TAG);
    }

    private static void startParsing(Document doc, String targetTag) {
        NodeList nodes = doc.getElementsByTagName(targetTag);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String data = element.getFirstChild().getNodeValue();
                System.out.println("Data: " + data);

                // if you want to stop the parsing if a certain tag is encountered, uncomment the following line
                // if (element.getTagName().equals(targetTag)) {
                //     System.out.println("Stopping parsing...");
                //     return;
                // }
            }
        }
    }
}