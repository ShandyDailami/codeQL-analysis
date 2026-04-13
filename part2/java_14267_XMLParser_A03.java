import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_14267_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml";  // Replace with your XML file path
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File(xmlFile));
            document.getDocumentElement().normalize();
            printTagsAndAttributes(document);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printTagsAndAttributes(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Tag: " + nodeList.item(i).getNodeName());
            System.out.println("Attributes: " + nodeList.item(i).getAttributes());
        }
    }
}