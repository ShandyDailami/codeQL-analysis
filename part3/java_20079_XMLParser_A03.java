import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_20079_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("example.xml");
            FileInputStream fis = new FileInputStream(file);

            // Get a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the input source
            Document doc = builder.parse(fis);

            // Contains the XML content
            String xmlContent = doc.getElements().toString();

            // Hash the XML content
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(xmlContent.getBytes());

            // Encode the hash to Base64
            String encodedString = Base64.getEncoder().encodeToString(messageDigest);

            System.out.println(encodedString);

            fis.close();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}