import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class java_01021_CredentialValidator_A08 {
    String username;
    String password;

    public java_01021_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

public class CredentialValidator {
    Map<String, String> allowedUsers = new HashMap<>();

    public java_01021_CredentialValidator_A08() {
        allowedUsers.put("user1", "password1");
        allowedUsers.put("user2", "password2");
        allowedUsers.put("user3", "password3");
    }

    public boolean validate(String username, String password) {
        if (allowedUsers.containsKey(username) && allowedUsers.get(username).equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        User user = new User("user1", "password1");

        if (validator.validate(user.username, user.password)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}