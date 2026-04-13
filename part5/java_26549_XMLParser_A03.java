import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class java_26549_XMLParser_A03 {
    private static final String MD5 = "MD5";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String xmlContent = "<user><name>John Doe</name><password>mypassword</password></user>";
        System.out.println("Original: " + xmlContent);

        String hashedPassword = getMD5Hash(xmlContent);
        System.out.println("Hashed: " + hashedPassword);
    }

    private static String getMD5Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(MD5);
        byte[] hash = md.digest(input.getBytes());
        return Base64.getEncoder().encodeToString(hash);
    }
}