import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_23509_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";  // path to your xml file
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(fileName);
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            System.out.println("Root element: " + root.getNodeName());

            printElement(root);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.println("- Element: " + element.getNodeName());
        System.out.println("  Text: " + element.getTextContent());

        Element child = element.getFirstChildElement();
        while (child != null) {
            printElement(child);
            child = child.getNextSiblingElement();
        }
    }
}