import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_24532_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse("src/main/resources/sample.xml"); // Use your own xml file

            NodeList nodeList = doc.getElementsByTagName("username");

            for (int i = 0; i < nodeList.getLength(); i++) {
                System.out.println("Username: " + nodeList.item(i).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}