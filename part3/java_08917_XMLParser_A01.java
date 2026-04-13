import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_08917_XMLParser_A01 {

    public static void main(String[] args) {
        String filePath = "path/to/your/xml/file.xml";
        parseXMLFile(filePath);
    }

    public static void parseXMLFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File(filePath));

            Element root = document.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            printElement(root);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void printElement(Element element) {
        // Print element details
        System.out.println("- Node name: " + element.getNodeName());
        System.out.println("- Node value: " + element.getNodeValue());

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Element childElement = (Element) children.item(i);
            System.out.println("  - Child node name: " + childElement.getNodeName());
            System.out.println("  - Child node value: " + childElement.getNodeValue());
        }

        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            printElement((Element) children.item(i));
        }
    }
}