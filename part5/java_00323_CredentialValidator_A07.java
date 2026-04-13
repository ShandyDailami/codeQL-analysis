public class java_00323_CredentialValidator_A07 {
    private final UserRepository userRepository;

    public java_00323_CredentialValidator_A07(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public CredentialStatus validateCredentials(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            return CredentialStatus.USERNAME_NOT_FOUND;
        } else if (!user.getPassword().equals(password)) {
            return CredentialStatus.PASSWORD_INCORRECT;
        } else {
            return CredentialStatus.SUCCESS;
        }
    }

    public enum CredentialStatus {
        SUCCESS,
        USERNAME_NOT_FOUND,
        PASSWORD_INCORRECT
    }
}