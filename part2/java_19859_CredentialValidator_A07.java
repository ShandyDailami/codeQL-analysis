public class java_19859_CredentialValidator_A07 {
    private String username;
    private String password;

    public java_19859_CredentialValidator_A07(String username, String password) {
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

public class CredentialValidator {
    private UserRepository userRepository;

    public java_19859_CredentialValidator_A07(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateCredentials(String username, String password) {
        User user = userRepository.findUser(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}

public class UserRepository {
    // This is a placeholder, the actual implementation of this class is not provided here
    // This class is used to simulate the behavior of a user repository
    public User findUser(String username) {
        // In a real application, the actual implementation would use a database to retrieve the user
        // This is just a placeholder
        return new User(username, "password");
    }
}