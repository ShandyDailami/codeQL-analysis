public class java_41175_CredentialValidator_A07 {
    private String username;
    private String password;

    // getters and setters

    public java_41175_CredentialValidator_A07(String username, String password) {
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

    public java_41175_CredentialValidator_A07(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateCredentials(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}

public class UserRepository {
    private List<User> users;

    public java_41175_CredentialValidator_A07() {
        users = new ArrayList<>();
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
        users.add(new User("user3", "password3"));
    }

    public User findByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }
}