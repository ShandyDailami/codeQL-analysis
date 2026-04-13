import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_11380_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "resources/sample.xml";
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(String fileName) {
        File xmlFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(xmlFile);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        doc.getDocumentElement().normalize();

        printElement(doc.getDocumentElement());
    }

    private static void printElement(Element elem) {
        System.out.println("Element: " + elem.getNodeName());

        NodeList children = elem.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + node.getNodeValue());
            } else {
                printElement((Element) node);
            }
        }
    }
}