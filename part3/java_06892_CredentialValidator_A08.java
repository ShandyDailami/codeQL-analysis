public class java_06892_CredentialValidator_A08 implements CredentialValidator {

    private UserRepository userRepository;
    private CryptoHelper cryptoHelper;

    public java_06892_CredentialValidator_A08(UserRepository userRepository, CryptoHelper cryptoHelper) {
        this.userRepository = userRepository;
        this.cryptoHelper = cryptoHelper;
    }

    @Override
    public CredentialStatus validateCredentials(String username, String password) {
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            return CredentialStatus.USERNAME_NOT_FOUND;
        }

        if (!user.isActive()) {
            return CredentialStatus.USER_INACTIVE;
        }

        if (!cryptoHelper.isValidPassword(password, user.getPassword())) {
            return CredentialStatus.INVALID_PASSWORD;
        }

        return CredentialStatus.VALID;
    }
}