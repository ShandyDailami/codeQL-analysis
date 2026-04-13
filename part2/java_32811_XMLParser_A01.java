import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_32811_XMLParser_A01 {

    public static void main(String[] args) {
        String xmlFile = "data.xml";  // sample xml file path
        parseXmlFile(xmlFile);
    }

    public static void parseXmlFile(String fileName) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // constructor is blocking
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(new File(fileName));

            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

            // Here we are assuming that the xml file only contains elements with children.
            // If the xml file contains complex data, you need a different method to iterate over all nodes.
            NodeList nodeList = document.getElementsByTagName("child");

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Child node " + (i+1) + ": " + nodeList.item(i).getTextContent());
            }

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}