public class java_12306_CredentialValidator_A08 {
    private final UserRepository userRepository;

    public java_12306_CredentialValidator_A08(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateCredentials(String username, String password) {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        if (!user.getPassword().equals(password)) {
            throw new IncorrectPasswordException("Incorrect password");
        }
        return true;
    }
}