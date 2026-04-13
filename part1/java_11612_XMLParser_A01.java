import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_11612_XMLParser_A01 {

    public static void main(String[] args) {
        // Create DocumentBuilderFactory and parse XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = builder.parse(new File("sample.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        }

        // Extract and print all element names
        getElementNames(doc, null);
    }

    private static void getElementNames(Document doc, String prefix) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            printElementName(nodes.item(i), prefix);
        }
    }

    private static void printElementName(org.w3c.dom.Node node, String prefix) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            String elementName = node.getNodeName();
            if (prefix != null) {
                System.out.println(prefix + elementName);
            } else {
                System.out.println(elementName);
            }

            // Recursively print element names with new prefix
            getElementNames((org.w3c.dom.Document) node, elementName + ".");
        }
    }
}