import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_28056_XMLParser_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        parseDocument("auth.xml");
    }

    public static void parseDocument(String filename) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(filename);
            Element root = doc.getDocumentElement();

            if (isValidCredentials(root)) {
                System.out.println("Access granted!");
            } else {
                System.out.println("Access denied!");
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidCredentials(Element root) {
        Element username = (Element) root.getElementsByTagName("username").item(0);
        Element password = (Element) root.getElementsByTagName("password").item(0);

        return USERNAME.equals(username.getTextContent()) && PASSWORD.equals(password.getTextContent());
    }
}