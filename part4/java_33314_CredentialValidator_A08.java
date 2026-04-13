import java.util.HashSet;
import java.util.Set;

public class java_33314_CredentialValidator_A08 {
    private static final Set<String> authorizedUsers = new HashSet<>();

    static {
        authorizedUsers.add("user1");
        authorizedUsers.add("user2");
        authorizedUsers.add("user3");
        // add more users as needed
    }

    public boolean validate(String user, String password) {
        // This is a simple check for the user's password. 
        // In a real-world application, you would typically use a more complex mechanism 
        // of hashing and comparing the password to a hashed value stored in the database.
        return authorizedUsers.contains(user) && password.equals("password");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("user1", "password"));  // prints: true
        System.out.println(validator.validate("wrongUser", "password"));  // prints: false
    }
}