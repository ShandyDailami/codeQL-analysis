import java.util.Optional;

public class java_28089_CredentialValidator_A03 {

    private final UserRepository userRepository;

    public java_28089_CredentialValidator_A03(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> validateCredentials(String username, String password) {
        // A real implementation would use encryption and hashing here
        // This example assumes that passwords are always plain text

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }
}