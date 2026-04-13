import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_38078_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("your_file.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            document.getDocumentElement().normalize();
            ListElement(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void ListElement(Document document) {
        NodeList nodeList = document.getElementsByTagName("element");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String name = element.getAttribute("name");
            String value = element.getAttribute("value");
            System.out.println("Name: " + name);
            System.out.println("Value: " + value);
        }
    }
}