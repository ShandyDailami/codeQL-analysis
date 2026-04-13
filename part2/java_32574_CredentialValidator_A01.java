import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class java_32574_CredentialValidator_A01 {
    private Map<String, String> userMap;

    public java_32574_CredentialValidator_A01() {
        userMap = new HashMap<>();
        userMap.put("admin", Base64.getEncoder().encodeToString("password".getBytes()));
        userMap.put("user", Base64.getEncoder().encodeToString("userpassword".getBytes()));
    }

    public boolean validate(String username, String password) {
        String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
        return encodedPassword.equals(userMap.get(username));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("admin", "password")); // true
        System.out.println(validator.validate("admin", "wrongpassword")); // false
        System.out.println(validator.validate("user", "userpassword")); // true
        System.out.println(validator.validate("user", "wrongpassword")); // false
    }
}