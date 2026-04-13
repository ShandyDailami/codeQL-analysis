import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_36218_XMLParser_A07 {
    public static void main(String[] args) {
        String xmlString = "<note>\n" +
                "<to>Tove</to>\n" +
                "<from>Jani</from>\n" +
                "<heading>Reminder</heading>\n" +
                "<body>Don't forget me this weekend!</body>\n" +
                "</note>";
        try {
            // Step 1: Create a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML from the Byte Array (xmlFile)
            Document document = builder.parse(new ByteArrayInputStream(xmlString.getBytes()));

            // Now you can process the document
            System.out.println("XML Parsed successfully");

            // Step 4: Hash the xmlString using MessageDigest
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(xmlString.getBytes());

            // Convert the byte to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            // Now hash the xmlString again using SHA-256
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hashSHA256 = sha256.digest(xmlString.getBytes());

            // Print SHA-256 hash
            System.out.println("SHA-256 hash: " + hexString);
            System.out.println("SHA-256 hash of SHA-256 hash: " + hexString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}