import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_10300_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("sample.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            printElementsAndAttributes(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementsAndAttributes(Document doc) {
        NodeList nl = doc.getElementsByTagName("*");
        for (int temp = 0; temp < nl.getLength(); temp++) {
            Element element = (Element) nl.item(temp);
            System.out.println("Element: " + element.getNodeName());
            NodeList attributes = element.getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                Node attribute = attributes.item(j);
                System.out.println("Attribute: " + attribute.getNodeName() + " = " + attribute.getTextContent());
            }
        }
    }
}