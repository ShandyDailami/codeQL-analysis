import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class java_04089_XMLParser_A01 {
    public static void main(String[] args) {
        String fileName = "example.xml"; // replace with your file name
        parseXMLFile(fileName);
    }

    public static void parseXMLFile(String fileName) {
        File inputFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("*");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("Node : " + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Element : " + eElement.getTagName());
                System.out.println("Attribute 'name' : " + eElement.getAttribute("name"));
                System.out.println("Attribute 'value' : " + eElement.getAttribute("value"));
            }
        }
    }
}