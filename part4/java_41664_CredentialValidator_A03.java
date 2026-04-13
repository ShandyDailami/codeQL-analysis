import java.util.HashSet;
import java.util.Set;

public class java_41664_CredentialValidator_A03 {

    private Set<String> validUsers = new HashSet<>();

    public java_41664_CredentialValidator_A03() {
        validUsers.add("user1");
        validUsers.add("user2");
        validUsers.add("user3");
    }

    public boolean validate(String user, String password) {
        if (validUsers.contains(user) && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Valid users
        System.out.println(validator.validate("user1", "password")); // true
        System.out.println(validator.validate("user2", "password")); // true
        System.out.println(validator.validate("user3", "password")); // true

        // Invalid users
        System.out.println(validator.validate("user4", "password")); // false
        System.out.println(validator.validate("user1", "wrongpassword")); // false
    }
}