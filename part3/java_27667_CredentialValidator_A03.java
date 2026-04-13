import java.util.HashMap;
import java.util.Map;

public class java_27667_CredentialValidator_A03 {
    private Map<String, String> userDB;

    public java_27667_CredentialValidator_A03() {
        userDB = new HashMap<>();
        userDB.put("admin", "password");
    }

    public boolean validateCredentials(String user, String password) {
        if (userDB.containsKey(user) && userDB.get(user).equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        if (validator.validateCredentials("admin", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}