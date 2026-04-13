import java.util.Base64;
import java.util.HashMap;

public class java_29394_CredentialValidator_A07 {

    private HashMap<String, String> userMap;

    public java_29394_CredentialValidator_A07() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
    }

    public boolean validate(String user, String password) {
        String hashedPassword = hashPassword(password);
        String hashedUser = hashPassword(user);

        if (userMap.containsKey(hashedUser) && userMap.get(hashedUser).equals(hashedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    private String hashPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("user1", "password1"); // true
        validator.validate("user2", "password2"); // true
        validator.validate("wrongUser", "wrongPassword"); // false
    }
}