import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_39165_XMLParser_A03 {
    private DocumentBuilderFactory factory;

    public java_39165_XMLParser_A03() {
        factory = DocumentBuilderFactory.newInstance();
    }

    public void parse(String fileName) {
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));

            // Security-sensitive operations:
            // 1. Retrieve XML file path
            String filePath = document.getDocumentElement().getNodePath();
            System.out.println("File path: " + filePath);

            // 2. Retrieve XML file content
            NodeList nodeList = document.getElementsByTagName("*");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                System.out.println("Node " + (i + 1) + ": " + node.getNodeName());
            }

            // 3. Retrieve XML attributes
            Element element = (Element) document.getElementsByTagName("tagName").item(0);
            System.out.println("Tag name: " + element.getTagName());
            System.out.println("Attribute: " + element.getAttribute("attributeName"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new XmlParser().parse("example.xml");
    }
}