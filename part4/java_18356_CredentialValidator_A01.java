public class java_18356_CredentialValidator_A01 {
    private UserRepository userRepository;

    public java_18356_CredentialValidator_A01(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validate(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            System.out.println("Invalid username");
            return false;
        }

        if (!user.getPassword().equals(password)) {
            System.out.println("Invalid password");
            return false;
        }

        System.out.println("Successfully logged in");
        return true;
    }
}