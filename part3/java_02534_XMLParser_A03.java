import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_02534_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");
        parseXML(xmlFile);
    }

    public static void parseXML(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc;
        try {
            doc = builder.parse(xmlFile);

            // Print out XML document elements and attributes
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            // Print out XML (not just the node contents, but also the tags and attributes)
            Element root = doc.getDocumentElement();
            printElement(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element elem) {
        System.out.print("Tag Name: " + elem.getTagName());
        System.out.print(" Attribute: " + elem.getAttribute("attribute"));
        System.out.print(" Text: " + elem.getText());

        NodeList children = elem.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printElement((Element) children.item(i));
        }
    }
}