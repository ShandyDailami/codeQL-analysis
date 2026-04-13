import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34576_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            String xmlFile = "/path/to/your/xml/file.xml";
            String expectedHash = "sha1:yourExpectedHash"; // SHA-1 hash of a file

            // Step 1: Parse XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new FileInputStream(xmlFile));

            // Step 2: Compute SHA-1 hash
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            InputStream fis = new FileInputStream(xmlFile);
            byte[] buffer = new byte[1024];
            int numRead = 0;
            while ((numRead = fis.read(buffer)) != -1) {
                md.update(buffer, 0, numRead);
            }
            fis.close();
            byte[] digest = md.digest();

            // Step 3: Compare computed hash to expected hash
            String computedHash = Base64.getEncoder().encodeToString(digest);
            if (!computedHash.equals(expectedHash)) {
                throw new SecurityException("Insecure XML file");
            }

            System.out.println("XML file is secure");
        } catch (SAXException | NoSuchAlgorithmException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}