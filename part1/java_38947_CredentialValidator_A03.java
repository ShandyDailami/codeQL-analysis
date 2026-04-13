public class java_38947_CredentialValidator_A03 {
    private UserDatabase userDatabase;

    public java_38947_CredentialValidator_A03(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public boolean isValidCredentials(String username, String password) {
        // Assume that UserDatabase implements the findUserByUsername method
        User user = userDatabase.findUserByUsername(username);

        if (user == null) {
            return false;
        }

        // Assume that User implements the verifyPassword method
        return user.verifyPassword(password);
    }
}

public interface UserDatabase {
    User findUserByUsername(String username);
}

public class User {
    private String username;
    private String password;

    public java_38947_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean verifyPassword(String password) {
        // Implement password verification here
        return this.password.equals(password);
    }
}