import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_07709_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "sample.xml";  // replace with your XML file
        parseXML(xmlFile);
    }

    public static void parseXML(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File(fileName));
            document.getDoctype(); // to remove doctype declaration
            printElements(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printElements(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");
        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println("Element: " + nodeList.item(i).getNodeName());
            System.out.println("Content: " + nodeList.item(i).getTextContent());
        }
    }
}