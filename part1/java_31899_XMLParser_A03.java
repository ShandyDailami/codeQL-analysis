import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.apache.xml.utils.DocumentHelper;
import org.xml.sax.SAXException;

public class java_31899_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        parseXMLFile(xmlFile);
    }

    private static void parseXMLFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(fileName);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList list = doc.getElementsByTagName("*");
        for (int i = 0; i < list.getLength(); i++) {
            System.out.println("Element #" + i + ": " + list.item(i).getNodeName());
        }
    }
}