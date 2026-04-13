import java.security.InvalidParameterException;

public class java_08649_CredentialValidator_A08 implements CredentialValidator {
    private UserRepository userRepository;

    public java_08649_CredentialValidator_A08(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean validate(String username, String password) throws InvalidParameterException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new InvalidParameterException("Invalid username");
        }

        if (!user.getPassword().equals(password)) {
            throw new InvalidParameterException("Invalid password");
        }

        return true;
    }
}