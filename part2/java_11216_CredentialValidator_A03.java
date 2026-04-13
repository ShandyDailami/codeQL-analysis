import java.util.HashMap;
import java.util.Map;

public class java_11216_CredentialValidator_A03 {
    private static Map<String, String> credentials;

    static {
        credentials = new HashMap<>();
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    public static boolean validate(String username, String password) {
        if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("user1", "password1"));  // True
        System.out.println(validate("user2", "wrongPassword"));  // False
        System.out.println(validate("user4", "password4"));  // False
    }
}