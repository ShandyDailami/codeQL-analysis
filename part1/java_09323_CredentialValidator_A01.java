public class java_09323_CredentialValidator_A01 {
    private UserRepository userRepository;

    public java_09323_CredentialValidator_A01(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateCredentials(String username, String password) {
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            System.out.println("User not found!");
            return false;
        }

        // Use secure way to compare passwords e.g., use BCrypt
        if (!user.getPassword().equals(password)) {
            System.out.println("Invalid password!");
            return false;
        }

        System.out.println("Access granted!");
        return true;
    }
}