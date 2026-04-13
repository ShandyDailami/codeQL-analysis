import java.util.HashMap;
import java.util.Map;

public class java_21493_CredentialValidator_A01 {

    private Map<String, String> credentialMap;

    public java_21493_CredentialValidator_A01() {
        credentialMap = new HashMap<>();
        credentialMap.put("user1", "password1");
        credentialMap.put("user2", "password2");
        credentialMap.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        return credentialMap.containsKey(username) && 
               credentialMap.get(username).equals(password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validate("user1", "password1")) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied for user1");
        }

        if (validator.validate("user2", "wrongpassword")) {
            System.out.println("Access granted for user2");
        } else {
            System.out.println("Access denied for user2");
        }
    }
}