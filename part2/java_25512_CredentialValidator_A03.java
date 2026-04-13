public class java_25512_CredentialValidator_A03 {

    private static CredentialValidator instance = null;
    private UserRepository userRepository;

    private java_25512_CredentialValidator_A03() {
        userRepository = new UserRepository();
    }

    public static CredentialValidator getInstance() {
        if (instance == null) {
            instance = new CredentialValidator();
        }
        return instance;
    }

    public boolean validateUserCredentials(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}