import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_34446_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "auth_failure.xml";
        File inputFile = new File(xmlFile);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException e) {
            System.out.println("Error: Parser Configuration Exception");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("Error: SAX Exception");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error: IO Exception");
            e.printStackTrace();
        }

        readXML(doc);
    }

    private static void readXML(Document doc) {
        NodeList nList = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Element Name: " + eElement.getNodeName());
                System.out.println("Element Value: " + eElement.getFirstChild().getNodeValue());
            }
        }
    }
}