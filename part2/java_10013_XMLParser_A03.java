import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_10013_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path/to/your/file.xml");
            parseXMLFile(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXMLFile(File xmlFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();
        Element root = document.getDocumentElement();

        printElement(root);
    }

    public static void printElement(Element element) {
        System.out.println("Element: " + element.getNodeName());
        System.out.println("Attribute: " + element.getAttribute("attribute"));

        // Recursive call for each child node
        for (int i = 0; i < element.getChildNodes().getLength(); i++) {
            printElement((Element) element.getChildNodes().item(i));
        }
    }
}