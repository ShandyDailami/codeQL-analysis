import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_07716_XMLParser_A08 {

    public static void main(String[] args) {
        parseAndPrintXml("sample.xml");
    }

    public static void parseAndPrintXml(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(new File(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();
        printElements(document.getElementsByTagName("*"));
    }

    private static void printElements(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            System.out.println("Element: " + element.getTagName());
            printAttributes(element.getAttributes());
            printElement(element);
        }
    }

    private static void printAttributes(javax.xml.dom.Attr[] attributes) {
        for (int i = 0; i < attributes.length; i++) {
            System.out.println("Attribute: " + attributes[i].getName() + " = " + attributes[i].getValue());
        }
    }

    private static void printElement(Element element) {
        System.out.println("Content: " + element.getTextContent());
        printElements(element.getElementsByTagName("*"));
    }
}