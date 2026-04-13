import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_12080_XMLParser_A07 {

    public static void main(String[] args) {
        String xml = "<authFailure><reason>A07_AuthFailure</reason><detail>Authentication failed.</detail></authFailure>";

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new StringReader(xml));

            String hashed = hashMessage(doc.getElementsByTagName("authFailure").item(0).getTextContent());

            System.out.println("Hashed value: " + hashed);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String hashMessage(String message) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(message.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException | java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}