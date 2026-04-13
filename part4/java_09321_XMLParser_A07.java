import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;

public class java_09321_XMLParser_A07 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parseXmlFile(inputFile);
    }

    public static void parseXmlFile(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;
        try {
            document = builder.parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        document.getDocumentElement().normalize();

        System.out.println("Root element: " + document.getDocumentElement().getNodeName());

        printElementInformation(document.getDocumentElement());
    }

    public static void printElementInformation(Element element) {
        System.out.println("Element: " + element.getNodeName());

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println("Text: " + node.getTextContent());
            } else {
                printElementInformation((Element) node);
            }
        }
    }
}