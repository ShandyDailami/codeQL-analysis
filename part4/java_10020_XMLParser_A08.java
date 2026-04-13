import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.zip.*;
import java.xml.parsers.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*;

public class java_10020_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            parse("src/main/resources/sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parse(String fileName) throws ParserConfigurationException, SAXException {
        // Create the factory object
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Create the document builder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Parse the XML file
        Document doc = builder.parse(new File(fileName));
        // Print the parsed XML
        printDocument(doc);
    }

    public static void printDocument(Document doc) {
        System.out.println(doc.getDocumentElement().getNodeName());
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            printNode(nodes.item(i));
        }
    }

    public static void printNode(Node node) {
        System.out.println("Node name: " + node.getNodeName());
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            System.out.println("Attributes: " + element.getAttribute("attr"));
            NodeList childNodes = node.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                printNode(childNodes.item(i));
            }
        } else {
            System.out.println("Node type: " + node.getNodeType());
            System.out.println("Node value: " + node.getNodeValue());
        }
    }
}