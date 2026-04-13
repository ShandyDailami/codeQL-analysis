import java.util.HashMap;
import java.util.Map;

public class java_15828_CredentialValidator_A01 {
    private Map<String, String> users;

    public java_15828_CredentialValidator_A01() {
        users = new HashMap<>();
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        boolean result = validator.validate("user1", "password1");
        System.out.println("Result: " + result);

        result = validator.validate("user2", "wrongpassword");
        System.out.println("Result: " + result);

        result = validator.validate("unknownuser", "password");
        System.out.println("Result: " + result);
    }
}