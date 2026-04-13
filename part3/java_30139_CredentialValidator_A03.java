public class java_30139_CredentialValidator_A03 implements CredentialValidator {

    private final UserRepository userRepository;

    public java_30139_CredentialValidator_A03(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean validate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new CredentialValidationException("Invalid username");
        }
        if (!isPasswordValid(user, password)) {
            throw new CredentialValidationException("Invalid password");
        }
        return true;
    }

    private boolean isPasswordValid(User user, String password) {
        // Assuming the password is hashed and compared in the database
        // In a real-world application, you should use a proper hashing function and compare hashes
        // The following is a simple example of how you might compare passwords
        return user.getHashedPassword().equals(hashPassword(password));
    }

    private String hashPassword(String password) {
        // Assuming you're using bcrypt for password hashing
        // You'll need to add the necessary imports and setup bcrypt
        // The following is a simple example of how you might hash a password
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}