public class java_18241_CredentialValidator_A01 implements CredentialValidator {

    private final UserRepository userRepository;

    public java_18241_CredentialValidator_A01(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String username = credential.getIdentifier();
        String password = new String(credential.getCredentials());

        // Fetch the user from the repository
        User user = userRepository.findUser(username);

        // Check if the password is correct
        if (user != null && user.getPassword().equals(password)) {
            return true;
        } else {
            throw new CredentialException("Invalid username or password");
        }
    }
}