public class java_33590_CredentialValidator_A03 {
    // Injecting UserRepository and PasswordEncoder for security-sensitive operations
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    // Constructor with UserRepository and PasswordEncoder dependencies
    public java_33590_CredentialValidator_A03(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Method to validate credentials
    public boolean validateCredentials(String username, String password) {
        // Retrieving user from repository
        User user = userRepository.findByUsername(username);

        // If user exists and password matches, return true
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return true;
        }

        // Otherwise, return false
        return false;
    }
}