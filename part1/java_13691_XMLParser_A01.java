import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_13691_XMLParser_A01 {

    public static void main(String[] args) {
        parseXML("secure.xml"); // Change this to the path of the secure.xml file
    }

    public static void parseXML(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(fileName);
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("secure");
            for (int i = 0; i < list.getLength(); i++) {
                Element element = (Element) list.item(i);

                String name = element.getAttribute("name");
                String password = element.getAttribute("password");

                // Security-sensitive operation: Broken Access Control
                // Compare the password attribute with a hard-coded password.
                // In a real application, it should be hashed and compared with a hashed password.
                if ("user".equals(name) && "pass".equals(password)) {
                    System.out.println("Access granted for user: " + name);
                } else {
                    System.out.println("Access denied for user: " + name);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}