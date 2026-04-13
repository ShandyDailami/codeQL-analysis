import java.util.Arrays;
import java.util.List;

public class java_30921_CredentialValidator_A01 {
    private List<UserCredential> allowedUsers = Arrays.asList(
            new UserCredential("user1", "password1"),
            new UserCredential("user2", "password2"),
            new UserCredential("user3", "password3"));

    public boolean validate(String username, String password) {
        for (UserCredential user : allowedUsers) {
            if (user.matches(username, password)) {
                return true;
            }
        }
        return false;
    }

    private class UserCredential {
        private String username;
        private String password;

        public java_30921_CredentialValidator_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean matches(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
}