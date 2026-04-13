import java.io.File;
import java.io.IOException;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_04437_XMLParser_A01 {

    private static DocumentBuilderFactory factory;
    private static Stack<Element> elementStack;

    static {
        factory = DocumentBuilderFactory.newInstance();
        elementStack = new Stack<>();
    }

    public static void main(String[] args) {
        String fileName = "src/test.xml";
        File xmlFile = new File(fileName);
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            printElementAndAttribute(document.getDocumentElement());
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElementAndAttribute(Element element) {
        System.out.println("Element Name: " + element.getNodeName());
        System.out.println("Element Attribute: " + element.getAttribute("attributeName"));

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) node;
                printElementAndAttribute(childElement);
            }
        }
    }
}