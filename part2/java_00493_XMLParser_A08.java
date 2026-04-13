import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_00493_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            parseXML("sample.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXML(String fileName) throws Exception {
        File inputFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        printTags(doc);
    }

    private static void printTags(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            org.w3c.dom.Node nNode = nList.item(temp);
            System.out.println("\nNode Name: " + nNode.getNodeName());
            if (nNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                org.w3c.dom.Element element = (org.w3c.dom.Element) nNode;
                System.out.println("Element Name: " + element.getTagName());
                List children = element.getChildNodes();
                for (int j = 0; j < children.getLength(); j++) {
                    org.w3c.dom.Node childNode = children.item(j);
                    if (childNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE)
                        System.out.println("Child Element Name: " + childNode.getNodeName());
                    if (childNode.getNodeType() == org.w3c.dom.Node.TEXT_NODE)
                        System.out.println("Text: " + childNode.getNodeValue());
                }
            }
        }
    }
}