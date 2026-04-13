import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class java_34555_XMLParser_A08 {

    private MessageDigest md;

    public java_34555_XMLParser_A08() {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isContentSecure(String xmlContent) {
        byte[] digest = md.digest(xmlContent.getBytes());
        String calculatedMD5 = Base64.getEncoder().encodeToString(digest);
        return Arrays.equals(md5("A08_IntegrityFailure".getBytes()), calculatedMD5.getBytes());
    }

    private byte[] md5(byte[] bytes) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(bytes);
            return digest;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}