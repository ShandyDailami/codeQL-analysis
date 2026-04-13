import java.awt.List;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_03285_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            parseXML("res/test.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String fileName) throws SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(new File(fileName));

        Element root = doc.getDocumentElement();

        printElement(root);
    }

    private static void printElement(Element element) {
        System.out.println("Element: " + element.getNodeName());
        printAttributes(element.getAttributes());

        List children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printElement((Element) children.item(i));
        }
    }

    private static void printAttributes(List attributes) {
        for (int i = 0; i < attributes.getLength(); i++) {
            Element attribute = (Element) attributes.item(i);
            System.out.println("Attribute: " + attribute.getNodeName() + " = " + attribute.getNodeValue());
        }
    }
}