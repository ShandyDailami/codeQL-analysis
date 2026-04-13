import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_30118_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_file.xml"); // replace with your file path
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("*");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                System.out.println("Element: " + element.getTagName());
                System.out.println("Value: " + element.getFirstChild().getNodeValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}