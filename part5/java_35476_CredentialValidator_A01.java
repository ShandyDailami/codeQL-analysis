import java.util.Optional;

public class java_35476_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_35476_CredentialValidator_A01(String username, String password) {
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

public interface CredentialRepository {
    Optional<User> findUserByUsername(String username);
}

public class CredentialService {
    private final CredentialRepository credentialRepository;

    public java_35476_CredentialValidator_A01(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    public boolean validateCredentials(String username, String password) {
        return credentialRepository.findUserByUsername(username)
                .filter(user -> user.getPassword().equals(password))
                .isPresent();
    }
}

public class CredentialValidator {
    private final CredentialService credentialService;

    public java_35476_CredentialValidator_A01(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    public boolean validate(String username, String password) {
        return credentialService.validateCredentials(username, password);
    }
}