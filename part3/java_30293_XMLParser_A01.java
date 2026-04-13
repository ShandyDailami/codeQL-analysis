import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_30293_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(File xmlFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            printElement(doc.getDocumentElement());

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.println("Element: " + element.getNodeName());

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printElement((Element) children.item(i));
        }
    }
}