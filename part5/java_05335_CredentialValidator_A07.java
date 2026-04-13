import java.util.Arrays;
import java.util.List;

public class java_05335_CredentialValidator_A07 {

    private List<UserCredential> validUsers = Arrays.asList(
            new UserCredential("user1", "pass1"),
            new UserCredential("user2", "pass2"),
            new UserCredential("user3", "pass3")
    );

    public boolean validate(String username, String password) {
        for (UserCredential user : validUsers) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // UserCredential class
    public class UserCredential {
        private String username;
        private String password;

        public java_05335_CredentialValidator_A07(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}