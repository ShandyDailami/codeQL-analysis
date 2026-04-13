import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_36532_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "people.xml";
        parseFile(fileName);
    }

    public static void parseFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(fileName));
        } catch (SAXException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nodeList = doc.getElementsByTagName("person");

        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            System.out.println("Person - " + (temp + 1));

            Node node = nodeList.item(temp);

            System.out.println("Name: " + getChildText(node, "name"));
            System.out.println("Age: " + getChildText(node, "age"));

            System.out.println();
        }
    }

    public static String getChildText(Node node, String childName) {
        Node n = node.getFirstChild();
        while (n != null) {
            if (n.getNodeName().equals(childName)) {
                return n.getTextContent();
            }
            n = n.getNextSibling();
        }
        return "";
    }
}