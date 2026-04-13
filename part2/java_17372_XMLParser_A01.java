import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_17372_XMLParser_A01 {

    public static void main(String[] args) {
        parseXmlFile("test.xml");
    }

    public static void parseXmlFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File(fileName));
            document.getDocumentElement().normalize();
            printElement(document.getDocumentElement());
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void printElement(Element element) {
        System.out.println("Element Name: " + element.getNodeName());
        if (element.hasChildNodes()) {
            NodeList childNodes = element.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node childNode = childNodes.item(i);
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    printElement((Element) childNode);
                } else if (childNode.getNodeType() == Node.TEXT_NODE) {
                    System.out.println("Child Node Value: " + childNode.getNodeValue());
                }
            }
        }
    }
}