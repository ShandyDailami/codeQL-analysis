import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_18346_XMLParser_A03 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String xml = "<document></document>";
        String securityInjection = "<script>alert('Injection detected!');</script>";

        // First, we'll use a simple XPath query to remove the comment
        xml = xml.replace("<!--.*?-->", "");

        // Next, we'll use a simple XPath query to remove the script tags
        xml = xml.replace("<script.*?</script>", "");

        // After that, we'll use a MessageDigest to remove the security-sensitive operations
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hashed = Base64.getEncoder().encodeToString(md.digest(securityInjection.getBytes()));
        xml = xml.replace(securityInjection, hashed);

        System.out.println(xml);
    }
}