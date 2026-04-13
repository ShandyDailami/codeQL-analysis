// CredentialValidator is an interface that validates credentials
public interface CredentialValidator {
    // Validate method to validate user credentials
    boolean validate(String username, String password);
}

// CustomCredentialValidator is a class java_34459_CredentialValidator_A03 validates credentials
public class CustomCredentialValidator implements CredentialValidator {

    private final UserRepository userRepository;

    public CustomCredentialValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Validate method to validate user credentials
    @Override
    public boolean validate(String username, String password) {
        // Use the userRepository to look up the user by username
        User user = userRepository.findByUsername(username);

        // If the user is not found or the password is incorrect
        if (user == null || !user.getPassword().equals(password)) {
            return false;
        }

        // If everything is correct, return true
        return true;
    }
}