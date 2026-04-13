import java.util.ArrayList;
import java.util.List;

public class java_33803_CredentialValidator_A01 {

    private List<String> acceptedUsernames = new ArrayList<>();
    private List<String> acceptedPasswords = new ArrayList<>();

    public java_33803_CredentialValidator_A01() {
        // Add some sample usernames and passwords
        this.acceptedUsernames.add("user1");
        this.acceptedUsernames.add("user2");
        this.acceptedPasswords.add("password1");
        this.acceptedPasswords.add("password2");
    }

    public boolean validate(String username, String password) {
        // Check if the username and password are in the accepted list
        if (this.acceptedUsernames.contains(username) && this.acceptedPasswords.contains(password)) {
            return true;
        } else {
            return false;
        }
    }
}