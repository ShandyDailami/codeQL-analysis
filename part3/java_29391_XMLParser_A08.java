import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;

public class java_29391_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");  // replace with your file path

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        NodeList list = doc.getElementsByTagName("*");

        for (int temp = 0; temp < list.getLength(); temp++) {
            Element e = (Element) list.item(temp);
            System.out.println("Element: " + e.getTagName());
            System.out.println("Attributes: ");
            for (int i = 0; i < e.getAttributes().getLength(); i++) {
                System.out.println(e.getAttributes().item(i).getNodeName() + " : " + e.getAttributes().item(i).getNodeValue());
            }
        }
    }
}