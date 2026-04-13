import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class java_05180_XMLParser_A08 {

    public static void main(String[] args) {
        String filePath = "sample.xml";
        parseXML(filePath);
    }

    private static void parseXML(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;

        try {
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();

        System.out.println("Root element: " + document.getDocumentElement().getNodeName());

        Iterator iterator = document.getElementsByTagName("*");

        while (iterator.hasNext()) {
            Node node = iterator.nextNode();
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("\nElement: " + element.getNodeName());
                System.out.println("Attribute: " + element.getAttribute("name"));
                System.out.println("Value: " + element.getAttribute("value"));
            }
        }
    }
}