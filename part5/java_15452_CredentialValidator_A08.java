import java.util.Base64;
import java.util.Arrays;

public class java_15452_CredentialValidator_A08 {

    private String storedCredentials;

    public java_15452_CredentialValidator_A08() {
        this.storedCredentials = "admin:admin"; // Base64 encoded "admin:admin"
    }

    public boolean validate(String username, String password) {
        byte[] decodedCredentials = Base64.getDecoder().decode(this.storedCredentials);
        String decodedString = new String(decodedCredentials);
        String[] credentials = decodedString.split(":");

        return Arrays.equals(credentials, new String[]{username, password});
    }

    public static void main(String[] args) {
        CredentialValidator cv = new CredentialValidator();
        System.out.println(cv.validate("admin", "admin")); // should print true
        System.out.println(cv.validate("admin", "wrong")); // should print false
    }
}