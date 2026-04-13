import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_09319_XMLParser_A01 {
    private static final String URL = "http://example.com/sample.xml";

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(URL);
            doc.getDocumentElement().normalize();

            NodeList nodes = doc.getElementsByTagName("node");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element node = (Element) nodes.item(i);

                // Security-sensitive operation: access control
                String accessControl = node.getAttribute("accessControl");
                if (accessControl.equals("Broken")) {
                    System.out.println("Broken Access Control detected");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}