public class java_10705_CredentialValidator_A03 implements CredentialValidator {
    // This is a mock for the user repository that we'll use to get users
    private UserRepository userRepository;

    public java_10705_CredentialValidator_A03(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CredentialValidationResult validate(String username, String password) {
        // Fetch user from repository
        User user = userRepository.findByUsername(username);

        // Check if user exists
        if (user == null) {
            return new CredentialValidationResult(false, "User not found");
        }

        // Check if password matches
        if (!user.getPassword().equals(password)) {
            return new CredentialValidationResult(false, "Password is incorrect");
        }

        // If everything is fine, return success
        return new CredentialValidationResult(true, "Successfully logged in");
    }
}

public class UserRepository {
    // This is a mock, in a real world scenario you'd probably use an ORM (Object Relational Mapping) library like Hibernate
    private List<User> users = new ArrayList<>();

    public User findByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }
}

public class User {
    private String username;
    private String password;

    public java_10705_CredentialValidator_A03(String username, String password) {
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