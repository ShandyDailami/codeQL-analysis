import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_40656_XMLParser_A07 {

    private static final String MD5 = "MD5";

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("sample.xml"));

        Map<String, String> authFailures = new HashMap<>();
        doc.getElementsByTagName("authFailure").forEach(el -> {
            String authAttempt = el.getTextContent();
            String encodedAuthAttempt = encodeWithMD5(authAttempt);
            authFailures.put(encodedAuthAttempt, el.getParentNode().getAttributes().getNamedItem("status").getTextContent());
        });

        System.out.println(authFailures);
    }

    private static String encodeWithMD5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(MD5);
        byte[] messageDigest = md.digest(input.getBytes());
        return Base64.getEncoder().encodeToString(messageDigest);
    }
}