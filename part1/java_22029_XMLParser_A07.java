import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_22029_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file.xml"); //replace with your xml file path
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            printElement(doc, doc.getDocumentElement());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Document doc, Element root) {
        NodeList children = doc.getElementsByTagName("*");
        for (int i = 0; i < children.getLength(); i++) {
            Node node = children.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Element: " + element.getTagName());
                printElement(doc, element);
            }
        }
    }
}