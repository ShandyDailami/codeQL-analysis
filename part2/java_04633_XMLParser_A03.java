import java.awt.List;
import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_04633_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFile = "/path/to/your/xml/file.xml"; // replace with your xml file

        try {
            File inputFile = new File(xmlFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            List<Element> elements = new ArrayList<>();
            parseElements(doc.getElementsByTagName("*"), elements);

            // Security sensitive operations here...
            // e.g., check for XSS attacks
            for (Element element : elements) {
                String innerXML = element.getInnerXml();
                // ...
            }

            System.out.println("XML Parsed Successfully");

        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }

    private static void parseElements(NodeList nodes, List<Element> elements) {
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            elements.add(element);
            parseElements(element.getElements(), elements);
        }
    }
}