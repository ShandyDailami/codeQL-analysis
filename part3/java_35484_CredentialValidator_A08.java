import java.util.Arrays;
import java.util.List;

public class java_35484_CredentialValidator_A08 {
    // A list of users and their passwords
    private List<UserCredential> userList = Arrays.asList(
            new UserCredential("user1", "password1"),
            new UserCredential("user2", "password2"),
            new UserCredential("user3", "password3")
    );

    // Credential validator
    public boolean validate(String username, String password) {
        for(UserCredential user : userList) {
            if(user.matches(username, password)) {
                return true;
            }
        }
        return false;
    }

    // User Credential class
    public class UserCredential {
        private String username;
        private String password;

        public java_35484_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean matches(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
}