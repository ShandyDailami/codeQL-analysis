public class java_19022_CredentialValidator_A07 {

    private UserRepository userRepository;

    public java_19022_CredentialValidator_A07(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validate(String username, String password) {
        User user = userRepository.findUserByUsername(username);

        if (user == null) {
            throw new AuthFailureException("User not found");
        }

        // Assume we have a method to check password
        boolean passwordValid = checkPassword(user, password);

        if (!passwordValid) {
            throw new AuthFailureException("Invalid password");
        }

        return true;
    }

    private boolean checkPassword(User user, String password) {
        // In a real-world scenario, you'd actually hash the password and compare the
        // hashed password to the stored hashed password in the database
        return user.getPassword().equals(password);
    }
}