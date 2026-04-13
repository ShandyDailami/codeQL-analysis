import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Permission;
import java.security.SecurityManager;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_23839_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            SecurityManager sm = System.getSecurityManager();
            sm.checkPermission(new Permission("accessControl"));

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            InputStream inputStream = new FileInputStream("sample.xml");
            Document doc = builder.parse(inputStream);

            System.out.println("Document parsing succeeded");

        } catch (SAXException e) {
            System.out.println("SAXException: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}