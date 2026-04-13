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

public class java_12755_XMLParser_A07 {

    public static void main(String[] args) {
        parseXMLFile("example.xml");
    }

    public static void parseXMLFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(fileName));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nodeList = doc.getElementsByTagName("student");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("Student " + (i + 1) + ":");
            printStudent(node);
        }
    }

    private static void printStudent(Node node) {
        Element element = (Element) node;
        System.out.println("ID: " + element.getAttribute("id"));
        System.out.println("Name: " + element.getAttribute("name"));
        System.out.println("Age: " + element.getAttribute("age"));
    }
}