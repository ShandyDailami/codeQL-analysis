import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_12910_XMLParser_A03 {
    public static void main(String[] args) {
        String filePath = "src/main/resources/legacyStyle.xml";
        parseXMLFile(filePath);
    }

    public static void parseXMLFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File xmlFile = new File(filePath);
        Document document;

        try {
            document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            printTagsAndAttributes(document);

            // Here you can add code related to security-sensitive operations related to injection.

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void printTagsAndAttributes(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Tag: " + nodeList.item(i).getNodeName());
            System.out.println("Attributes: " + nodeList.item(i).getAttributes());
        }
    }
}