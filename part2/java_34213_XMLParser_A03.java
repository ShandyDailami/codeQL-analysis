import java.io.File;
import java.io.IOException;
import java.security.CodeSignException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_34213_XMLParser_A03 {

    public static void main(String[] args) {
        String url = "path_to_your_xml_file.xml"; // replace with your file path
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;
        try {
            doc = builder.parse(new File(url));
            doc.getDocumentElement().normalize();
            printElements(doc);
        } catch (SAXException | CodeSignException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(Document doc) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            System.out.println("Element: " + element.getTagName());
        }
    }
}