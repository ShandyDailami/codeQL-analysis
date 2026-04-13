import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class java_33896_XMLParser_A03 {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;

        try {
            doc = builder.parse(new File("input.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        NodeList nlist = doc.getElementsByTagName("*");

        for (int temp = 0; temp < nlist.getLength(); temp++) {

            Node node = nlist.item(temp);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) node;
                System.out.println("Element: " + e.getTagName());
                System.out.println("Attribute: " + "name - " + e.getAttribute("name"));
                System.out.println("Value: " + e.getFirstChild().getNodeValue());
            }
        }
    }
}