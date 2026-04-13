import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_34241_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "sample.xml";

        // Create a factory for building DOM tree
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // Create a new document
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));

            // Normalize the document
            document.getDocumentElement().normalize();

            // Print all element names and attributes
            printElementsAndAttributes(document);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document document) {
        NodeList nodeList = document.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);

            System.out.println("Element: " + element.getTagName());

            NodeList attrList = element.getAttributes();
            for (int j = 0; j < attrList.getLength(); j++) {
                System.out.println("  Attribute: " + attrList.item(j).getNodeName() + " = " + attrList.item(j).getNodeValue());
            }
       
        }
    }
}