import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;

public class java_12087_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // replace with your file path
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            printElement(doc.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.println("Element: " + element.getNodeName());
        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + node.getTextContent());
            } else {
                printElement((Element) node);
            }
        }
    }
}