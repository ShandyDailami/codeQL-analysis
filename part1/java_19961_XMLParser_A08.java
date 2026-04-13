import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_19961_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File("sample.xml")); // replace with your xml file
            document.getDoctype(); // this is optional

            printElementList(document.getElementsByTagName("*"));

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElementList(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            printElement((Element) nodeList.item(i));
        }
    }

    private static void printElement(Element element) {
        System.out.println("Tag Name: " + element.getTagName());
        System.out.println("Element Value: " + element.getTextContent());

        NodeList childNodes = element.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            printElement((Element) childNodes.item(i));
        }
    }
}