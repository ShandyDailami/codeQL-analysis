import java.util.Base64;
import java.util.HashMap;

public class java_39308_CredentialValidator_A08 {
    private HashMap<String, String> users = new HashMap<String, String>();

    public java_39308_CredentialValidator_A08() {
        users.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
    }

    public boolean validate(String username, String password) {
        String expectedPassword = users.get(username);
        if (expectedPassword == null) {
            return false;
        } else {
            byte[] decodedPassword = Base64.getDecoder().decode(expectedPassword);
            String decodedPasswordString = new String(decodedPassword);
            return password.equals(decodedPasswordString);
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Validate with correct credentials
        System.out.println(validator.validate("admin", "password"));

        // Validate with incorrect credentials
        System.out.println(validator.validate("admin", "wrongpassword"));
    }
}