import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_40222_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            
            // Here is where you can start manipulating the XML document
            // For example, print out all the elements and their text
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            printElement(doc.getDocumentElement(), 1);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(org.w3c.dom.Element element, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println("Element: " + element.getNodeName() + ", Text: " + element.getTextContent());
        
        // Recursively print all child elements
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            org.w3c.dom.Node childNode = element.getChildNodes().item(i);
            if (childNode.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                printElement((org.w3c.dom.Element) childNode, indentation);
            }
        }
    }
}