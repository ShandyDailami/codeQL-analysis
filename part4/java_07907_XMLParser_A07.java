import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_07907_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFile = "credentials.xml";
        String username = null;
        String password = null;

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(xmlFile));

            doc.getDocumentElement().normalize();
            username = doc.getElementsByTagName("username").item(0).getTextContent();
            password = doc.getElementsByTagName("password").item(0).getTextContent();

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

        } catch (SAXException | IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}