import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_19538_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            printElements(doc, doc.getDocumentElement());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc, Element root) {
        NodeList list = doc.getElementsByTagName("*");
        for (int i = 0; i < list.getLength(); i++) {
            Element e = (Element) list.item(i);

            System.out.println("Element: " + e.getTagName());
            System.out.println("Attributes: ");

            for (int j = 0; j < e.getAttributes().getLength(); j++) {
                System.out.println("Attribute: " + e.getAttributes().item(j).getNodeName() + " = " + e.getAttributes().item(j).getNodeValue());
            }

            if (e.hasChildNodes()) {
                printElements(doc, e);
            }
        }
    }
}