import java.io.File;
import java.util.List;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class java_03447_XMLParser_A08 {

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        parser.parseXmlFile("example.xml");
    }

    public void parseXmlFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File(fileName));
            document.getDoctype();

            validateIntegrity(document);

        } catch (Exception e) {
            System.out.println("Error parsing XML file: " + e.getMessage());
        }
    }

    private void validateIntegrity(Document document) {
        NodeList nodes = document.getElementsByTagName("node");

        Stream.of(nodes).forEach(node -> {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                // Add your security-sensitive operations here
                // Example: Checking for invalid characters in the node's content
                String content = node.getTextContent();
                if (content.contains("<")) {
                    System.out.println("A08_IntegrityFailure: Invalid character found in content: " + content);
                }
            }
        });
    }
}