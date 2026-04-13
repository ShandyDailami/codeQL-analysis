import java.awt.print.PrintJob;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class java_13795_XMLParser_A03 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new FileReader("example.xml"));
            doc.getDocumentElement().normalize();
            printNodes(doc.getElementsByTagName("note"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printNodes(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            printNode(nodes.getItem(i));
        }
    }

    private static void printNode(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.println("Found a note: " + element.getTagName());
            printAttributes(element.getAttributes());
            printNode(element.getFirstChild());
        }
    }

    private static void printAttributes(javax.xml.dom.Attr[] attrs) {
        for (int i = 0; i < attrs.length; i++) {
            System.out.println("Found attribute: " + attrs[i].getName() + "=" + attrs[i].getValue());
        }
    }
}