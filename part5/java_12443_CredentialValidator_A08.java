import java.util.ArrayList;
import java.util.List;

public class java_12443_CredentialValidator_A08 {

    // Hardcoded list of valid credentials
    private static List<String> validUsers = new ArrayList<>();

    static {
        validUsers.add("user1");
        validUsers.add("user2");
        validUsers.add("user3");
    }

    // Method to validate the credentials
    public static boolean validate(String user, String password) {
        if (validUsers.contains(user) && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // You can test the validator here
        if (validate("user1", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}