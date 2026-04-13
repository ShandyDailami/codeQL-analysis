import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_32236_XMLParser_A08 {
    public static void main(String[] args) {
        String xmlFile = "example.xml"; // replace with your xml file path
        String elementName = "elementName"; // replace with the name of the element you want to retrieve

        readAndRetrieveElement(xmlFile, elementName);
    }

    public static void readAndRetrieveElement(String xmlFile, String elementName) {
        File xmlFileIn = new File(xmlFile);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(xmlFileIn);
            doc.getDocumentElement().normalize();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return;
        }

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName(elementName);

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Element eElement = (Element) nList.item(temp);
            System.out.println("Value of element: " + eElement.getTextContent());
        }
    }
}