import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class java_29822_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            List<Element> elements = new ArrayList<>();
            getElements(doc.getDocumentElement(), elements);

            for (Element element : elements) {
                System.out.println("Element Name: " + element.getNodeName());
                System.out.println("Element Value: " + element.getFirstChild().getNodeValue());
            }

        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void getElements(Element element, List<Element> elements) {
        elements.add(element);

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) node;
                getElements(childElement, elements);
            }
        }
    }
}