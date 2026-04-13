import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_35354_XMLParser_A08 {
    public static void main(String[] args) {
        String fileName = "example.xml";
        File file = new File(fileName);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(file);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            System.out.println("Element: " + element.getTagName());
            System.out.println("Value: " + element.getFirstChild().getNodeValue());
        }
    }
}