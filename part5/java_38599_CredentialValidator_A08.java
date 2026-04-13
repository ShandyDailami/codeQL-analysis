public class java_38599_CredentialValidator_A08 {
    private UserRepository userRepository;

    public java_38599_CredentialValidator_A08(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValidCredentials(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new CredentialFailureException("Invalid username");
        }

        if (!user.getPassword().equals(password)) {
            throw new CredentialFailureException("Invalid password");
       
        }

        return true;
    }
}

public class CredentialFailureException extends RuntimeException {
    public java_38599_CredentialValidator_A08(String message) {
        super(message);
    }
}