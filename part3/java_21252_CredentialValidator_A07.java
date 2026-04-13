import java.util.HashSet;
import java.util.Set;

public class java_21252_CredentialValidator_A07 {
    private Set<String> usernames;
    private Set<String> passwords;

    public java_21252_CredentialValidator_A07() {
        this.usernames = new HashSet<>();
        this.passwords = new HashSet<>();

        // Add some dummy credentials for testing
        this.usernames.add("user1");
        this.passwords.add("password1");
        this.usernames.add("user2");
        this.passwords.add("password2");
    }

    public boolean validate(String username, String password) {
        if (!this.usernames.contains(username)) {
            System.out.println("Invalid username");
            return false;
        }

        if (!this.passwords.contains(password)) {
            System.out.println("Invalid password");
            return false;
       
        }

        System.out.println("Successfully authenticated!");
        return true;
    }
}