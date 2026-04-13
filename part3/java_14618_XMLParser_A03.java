import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class java_14618_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElementsByTagName("root").item(0).getTextContent());
            printElement(doc.getElementsByTagName("element").item(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.println("Element name : " + element.getElementsByTagName("name").item(0).getTextContent());
        System.out.println("Element attribute : " + element.getAttribute("attribute"));
        NodeList children = element.getElementsByTagName("child");
        for (int i = 0; i < children.getLength(); i++) {
            printElement((Element) children.item(i));
        }
    }
}