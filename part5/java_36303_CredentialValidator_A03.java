import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_36303_CredentialValidator_A03 {

    private Map<String, String> credentials;

    public java_36303_CredentialValidator_A03() {
        this.credentials = new HashMap<>();
        this.credentials.put("admin", this.encodePassword("password"));
    }

    public boolean validate(String username, String password) {
        if (this.credentials.containsKey(username) &&
            this.credentials.get(username).equals(this.encodePassword(password))) {
            return true;
        }
        return false;
    }

    private String encodePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes("UTF-8"));
            return new String(Base64.getEncoder().encode(hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();
        System.out.println(validator.validate("admin", "password")); // Outputs: true
        System.out.println(validator.validate("user", "password")); // Outputs: false
    }
}