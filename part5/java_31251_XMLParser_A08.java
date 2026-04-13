import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_31251_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getDocumentElement().getNodeName());

            NodeList nodes = doc.getElementsByTagName("*");
            for (int temp = 0; temp < nodes.getLength(); temp++) {
                Element e = (Element) nodes.item(temp);
                System.out.println("Element : " + e.getTagName());
                System.out.println("Attribute : " + e.getAttribute("name"));
                System.out.println("Value : " + e.getFirstChild().getNodeValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}