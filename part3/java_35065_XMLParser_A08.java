import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.XMLConstants;
import org.xml.sax.SAXException;

public class java_35065_XMLParser_A08 {

    public static void main(String[] args) {
        String filePath = "/path/to/your/file.xml";
        parseFile(filePath);
    }

    public static void parseFile(String filePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true); // Enable validation for strict XML syntax

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File(filePath));
        } catch (SAXException e) {
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            System.out.println("Tag: " + element.getTagName());
            System.out.println("Value: " + element.getFirstChild().getNodeValue());
        }
    }
}