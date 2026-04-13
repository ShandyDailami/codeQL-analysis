import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_33861_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/example.xml");
        parseXml(xmlFile);
    }

    public static void parseXml(File xmlFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // TODO: Implement security-sensitive operations related to A03_Injection.
            // For instance, print the XML elements.
            System.out.println("XML File Contents:");
            printXml(doc, doc.getDocumentElement());

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printXml(Document doc, org.w3c.dom.Node node) {
        if (node.hasChildNodes()) {
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                printXml(doc, node.getChildNodes().item(i));
            }
        } else if (node.getNodeType() == Node.TEXT_NODE) {
            System.out.println(node.getNodeValue());
        } else {
            System.out.println("Element : " + node.getNodeName());
        }
    }
}