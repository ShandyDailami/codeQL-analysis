import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_20819_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        File inputFile = new File(xmlFile);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        } catch (IOException e) {
            System.out.println("Error parsing the XML file.");
            e.printStackTrace();
        }
        readXML(doc);
    }

    private static void readXML(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node node = nodeList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String name = element.getNodeName();
                String value = element.getFirstChild().getNodeValue();
                System.out.println("Element: " + name + ", Value: " + value);
            }
        }
    }
}