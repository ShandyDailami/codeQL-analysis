import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_06072_CredentialValidator_A07 {
    private Map<String, String> userData;

    public java_06072_CredentialValidator_A07() {
        userData = new HashMap<>();
        userData.put("user1", Base64.getEncoder().encodeToString("password1".getBytes()));
        userData.put("user2", Base64.getEncoder().encodeToString("password2".getBytes()));
    }

    public boolean validate(String username, String password) {
        if (userData.containsKey(username)) {
            byte[] decodedPassword = Base64.getDecoder().decode(userData.get(username));
            return new String(decodedPassword).equals(password);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator();

        System.out.println(validator.validate("user1", "password1")); // true
        System.out.println(validator.validate("user3", "password1")); // false
    }
}