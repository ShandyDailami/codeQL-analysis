import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class java_00794_XMLParser_A01 {

    public static void main(String[] args) {
        parseXMLUsingSAX();
        parseXMLUsingDOM();
    }

    private static void parseXMLUsingSAX() {
        System.out.println("\nSAX Parsing:");

        try {
            SAXReader saxReader = new SAXReader();
            File xmlFile = new File("sample.xml");
            saxReader.setValidation(true);
            XMLReader xmlReader = saxReader.buildReader(xmlFile);
            xmlReader.parse(xmlFile);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseXMLUsingDOM() {
        System.out.println("\nDOM Parsing:");

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File xmlFile = new File("sample.xml");
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("item");
            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Item " + (i + 1) + ": " + nodeList.item(i).getTextContent());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}