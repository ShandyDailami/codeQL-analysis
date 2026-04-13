import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_09975_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse("src/test.xml");

            document.getDocumentElement().normalize();

            System.out.println("Root element: " + document.getElementsByTagName("test").item(0).getTextContent());

            List<NodeList> nodeList = document.getElementsByTagName("test");

            for (int i = 0; i < nodeList.get(0).getLength(); i++) {
                System.out.println("Test element " + (i+1) + ": " + nodeList.get(0).item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}