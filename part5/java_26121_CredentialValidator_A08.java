public class java_26121_CredentialValidator_A08 {

    private UserRepository userRepository;

    public java_26121_CredentialValidator_A08(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateCredentials(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new CredentialFailureException("No user found with the provided username");
        }

        if (!user.getPassword().equals(hashPassword(password))) {
            throw new CredentialFailureException("Invalid password");
        }

        return true;
    }

    // For the sake of example, let's consider that the password is hashed.
    // In reality, passwords should never be stored in plain text, so this should ideally be done in a more secure way.
    private String hashPassword(String password) {
        // In a real-world scenario, you should use a stronger hash algorithm and a random salt.
        return password;
    }

    // Exception for CredentialFailure
    public class CredentialFailureException extends RuntimeException {
        public java_26121_CredentialValidator_A08(String message) {
            super(message);
        }
    }
}