import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_11745_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        try {
            // Create a MessageDigest instance for SHA-256 hashing
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Read the file
            InputStream input = new FileInputStream("legacy.xml");
            byte[] buffer = new byte[1024];
            int bytesNumRead = 0;
            while ((bytesNumRead = input.read(buffer)) != -1) {
                md.update(buffer, 0, bytesNumRead);
            }
            input.close();

            // Get the hash
            byte[] hash = md.digest();

            // Base64 encode the hash
            String encodedHash = Base64.getEncoder().encodeToString(hash);

            // Now, let's parse the XML document again, but this time use a secure way to do it
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            factory.setNamespaceAware(false);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new FileInputStream("legacy.xml"));

            // Perform a security-sensitive operation here using the document
            // This is a dummy operation, just to demonstrate the injection
            String sensitiveOperation = doc.getTextContent();
            System.out.println("Performed Sensitive Operation: " + sensitiveOperation);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}