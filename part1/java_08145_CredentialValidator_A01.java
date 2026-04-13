public class java_08145_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_08145_CredentialValidator_A01(String username, String password) {
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

public class Credential {
    private String username;
    private String password;

    public java_08145_CredentialValidator_A01(String username, String password) {
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

public interface CredentialValidator {
    boolean validate(Credential credential);
}

public class CredentialValidatorImpl implements CredentialValidator {
    private UserRepository userRepository;

    public java_08145_CredentialValidator_A01(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean validate(Credential credential) {
        User user = userRepository.findUserByUsername(credential.getUsername());
        return user != null && user.getPassword().equals(credential.getPassword());
    }
}

public class UserRepository {
    private List<User> users;

    public java_08145_CredentialValidator_A01() {
        users = new ArrayList<>();
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));
    }

    public User findUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}