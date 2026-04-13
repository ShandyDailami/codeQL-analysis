import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class java_09551_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
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
            Node n = nl.item(temp);
            if (n instanceof Element) {
                Element e = (Element) n;
                System.out.println("Element Name: " + e.getTagName());
                System.out.println("Element Attributes: " + e.getAttributes());
            }
        }
    }
}