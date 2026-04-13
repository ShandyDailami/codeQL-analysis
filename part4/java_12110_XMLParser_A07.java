import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_12110_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            String xmlContent = "<authFailure><user>username</user><password>password</password></authFailure>";
            parseXML(xmlContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXML(String xmlContent) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(xmlContent.getBytes());

        X509Certificate cert = (X509Certificate) doc.getElementsByTagName("authFailure").item(0);

        String user = getHashedPassword(cert.getSubjectDN().getName());

        System.out.println("User: " + user);
    }

    private static String getHashedPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}