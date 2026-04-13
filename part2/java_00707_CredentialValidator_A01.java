import java.util.Optional;

public class java_00707_CredentialValidator_A01 {

    private UserRepository userRepository;

    public java_00707_CredentialValidator_A01(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> validateCredentials(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            User dbUser = user.get();
            if (dbUser.getPassword().equals(password)) {
                return Optional.of(dbUser);
            }
        }
        return Optional.empty();
    }
}