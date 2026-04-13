import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_37298_XMLParser_A08 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(new File("input.xml"));
            doc.getDocumentElement().normalize();
            printElement(doc.getDocumentElement());

        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        String elementName = element.getNodeName();
        System.out.println("Element: " + elementName);

        String elementValue = element.getTextContent();
        System.out.println("Element Value: " + elementValue);

        int childCount = element.getChildNodes().getLength();
        System.out.println("Child Count: " + childCount);

        for (int i = 0; i < childCount; i++) {
            printElement((Element) element.getChildNodes().item(i));
        }
    }
}