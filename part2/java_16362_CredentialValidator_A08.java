import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;

public class java_16362_CredentialValidator_A08 {

    private static final HashMap<String, String> users = new HashMap<>();

    static {
        users.put("alice", "password");
        users.put("bob", "password");
    }

    public boolean validate(String username, String password) {
        String expectedPassword = users.get(username);
        if (expectedPassword == null) {
            return false;
        }

        byte[] decodedPassword = Base64.getDecoder().decode(expectedPassword);
        String decodedPasswordString = new String(decodedPassword);

        return decodedPasswordString.equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("alice", "password")); // true
        System.out.println(validator.validate("alice", "wrongpassword")); // false
        System.out.println(validator.validate("bob", "password")); // false
    }
}