public class java_18902_CredentialValidator_A07 implements CredentialValidator {

    private UserRepository userRepository;

    public java_18902_CredentialValidator_A07(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean validate(Credential credential) {
        User user = userRepository.findByUsername(credential.getUsername());
        if (user == null) {
            throw new AuthFailure("User not found");
        }
        if (!user.getPassword().equals(credential.getPassword())) {
            throw new AuthFailure("Password incorrect");
        }
        return true;
    }
}