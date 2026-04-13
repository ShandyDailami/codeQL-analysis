import java.util.Base64;
import java.util.zip.DataNotFoundException;

public class java_31198_CredentialValidator_A07 {

    private Credential credential;

    public java_31198_CredentialValidator_A07(Credential credential) {
        this.credential = credential;
    }

    public boolean validate(String username, String password) {
        try {
            String decodedCredentials = new String(Base64.getDecoder().decode(credential.getPassword()), "UTF-8");
            return decodedCredentials.equals(username) && decodedCredentials.equals(password);
        } catch (DataNotFoundException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Credential credential = new Credential("admin", "YWJjZGVmZGVk"); // Admin and password in base64
        CredentialValidator validator = new CredentialValidator(credential);
        System.out.println(validator.validate("admin", "password")); // Should print: true
    }
}

class Credential {
    private String username;
    private String password;

    public java_31198_CredentialValidator_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}