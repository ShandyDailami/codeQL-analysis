import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidParameterException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_38178_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create a new instance of the DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse the XML file
            Document doc = builder.parse(new FileInputStream("input.xml"));

            // Get the integrity failure
            String integrityFailure = "A08_IntegrityFailure";

            // Check the XML file against the integrity failure
            checkXMLIntegrity(doc, integrityFailure);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (DocumentBuilderFactory.InvalidDocumentException e) {
            e.printStackTrace();
        } catch (InvalidParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void checkXMLIntegrity(Document doc, String integrityFailure) throws NoSuchAlgorithmException, InvalidParameterException {
        // Calculate the MD5 hash of the document
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(doc.getDocumentElement().getFirstChild().getNodeValue().getBytes());

        // Convert the digest to a hexadecimal string
        String hash = bytesToHex(digest);

        // Check if the hash matches the integrity failure
        if (hash.equals(integrityFailure)) {
            System.out.println("The XML file is secure against the integrity failure.");
        } else {
            System.out.println("The XML file is NOT secure against the integrity failure.");
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }
}