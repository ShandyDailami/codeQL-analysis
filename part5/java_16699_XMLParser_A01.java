import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_16699_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("input.xml"));

            // normalize document
            document.getDocumentElement().normalize();

            // print XML document elements
            printElements(document);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document document) {
        NamedNodeMap nodeMap = document.getElementsByTagName("*").item(0).getChildNodes();
        for (int i = 0; i < nodeMap.getLength(); i++) {
            Node node = nodeMap.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getTagName());
                printElements(element);
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + node.getNodeValue());
            }
        }
    }
}