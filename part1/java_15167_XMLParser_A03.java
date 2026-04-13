import java.io.File;
import java.io.IOException;
import java.security.CodeSigningException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_15167_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            List<Element> elements = extractElements(doc);
            printElements(elements);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static List<Element> extractElements(Document doc) {
        return null; // TODO: implement this method
    }

    private static void printElements(List<Element> elements) {
        for (Element element : elements) {
            System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent());
            System.out.println("Value: " + element.getElementsByTagName("value").item(0).getTextContent());
        }
    }
}