import java.util.HashMap;
import java.util.Map;

public class java_16896_CredentialValidator_A03 {
    private Map<String, String> userMap;

    public java_16896_CredentialValidator_A03() {
        userMap = new HashMap<>();
        userMap.put("user1", "password1");
        userMap.put("user2", "password2");
        userMap.put("user3", "password3");
    }

    public boolean validate(String user, String password) {
        return userMap.containsKey(user) && userMap.get(user).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("user1", "password1")); // true
        System.out.println(validator.validate("user4", "password4")); // false
        System.out.println(validator.validate("user1", "wrongpassword")); // false
    }
}