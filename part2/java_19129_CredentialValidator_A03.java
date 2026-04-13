import java.security.cert.X509Certificate;

public class java_19129_CredentialValidator_A03 implements CredentialValidator {

    // Fields for injection
    private UserRepository userRepository;

    // Constructor
    public java_19129_CredentialValidator_A03(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean validate(X509Certificate cert, String authType) {
        // This is a dummy authentication. In real scenario, a secure way of authenticating user
        // would be to use username and password, and compare them with the user in the database.
        // For simplicity, let's assume the authentication is successful when the user repository
        // returns a non-null user.
        return userRepository.findByUsernameAndPassword(cert.getSubjectDN().getName(), cert.getNotAfter().getTime()) != null;
    }
}