import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_12866_XMLParser_A03 {
    public static void main(String[] args) {
        String filePath = "sample.xml"; // replace with your file path
        parseXML(filePath);
    }

    private static void parseXML(String filePath) {
        File inputFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            printElements(doc.getElementsByTagName("element"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(NodeList nList) {
        for (int i = 0; i < nList.getLength(); i++) {
            Element e = (Element) nList.item(i);
            printElement(e);
        }
    }

    private static void printElement(Element e) {
        // print out the element and its attributes
        System.out.println("Element: " + e.getNodeName());
        System.out.println("Attribute: " + e.getAttributeNode("attribute").getNodeValue());

        // recursively print out child elements
        List<Element> childs = e.getElementsByTagName("child");
        for (int i = 0; i < childs.size(); i++) {
            printElement((Element) childs.item(i));
        }
    }
}