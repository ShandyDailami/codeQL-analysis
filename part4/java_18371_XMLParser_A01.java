import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_18371_XMLParser_A01 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("example.xml"));

            doc.getDocumentElement().normalize();

            NodeList nl = doc.getElementsByTagName("*");

            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) n;
                    System.out.println("Element: " + e.getTagName());
                    System.out.println("Attribute: " + e.getAttribute("name"));
                    System.out.println("Value: " + e.getFirstChild().getNodeValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}