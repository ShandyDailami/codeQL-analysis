public class java_10050_CredentialValidator_A01 {
    private static final Logger logger = LoggerFactory.getLogger(CredentialValidator.class);

    private final UserRepository userRepository;
    private final CredentialService credentialService;

    public java_10050_CredentialValidator_A01(UserRepository userRepository, CredentialService credentialService) {
        this.userRepository = userRepository;
        this.credentialService = credentialService;
    }

    public boolean validateUserCredentials(String userId, String password) {
        User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            logger.warn("Invalid userId: {}", userId);
            return false;
        }

        if (!credentialService.verifyPassword(password, user.getPassword())) {
            logger.warn("Invalid password for user: {}", userId);
            return false;
        }

        return true;
    }
}