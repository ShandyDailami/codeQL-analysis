import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_28020_XMLParser_A08 {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("test.xml"));

            doc.getDocumentElement().normalize();

            System.out.println("Root Element: " + doc.getElementsByTagName("note").item(0).getTextContent());
            printElement(doc.getElementsByTagName("note").item(0));
            System.out.println("Another Element: " +
                    doc.getElementsByTagName("author").item(0).getTextContent());
            printElement(doc.getElementsByTagName("author").item(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElement(Element element) {
        System.out.print("Element: ");
        System.out.print(element.getNodeName());
        System.out.print(" - ");
        System.out.print(element.getAttributes().getNamedItem("name").getNodeValue());
        System.out.print(" - ");
        System.out.print(element.getTextContent());
        System.out.println("");
    }
}