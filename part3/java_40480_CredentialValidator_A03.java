import java.util.Base64;

public class java_40480_CredentialValidator_A03 {
    // Assume we have a UserRepository interface
    // UserRepository is an interface with a method that takes a username and password and returns a User if the credentials are valid
    // If the credentials are not valid, null is returned
    private UserRepository userRepository;

    public java_40480_CredentialValidator_A03(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User validate(String username, String password) {
        // Decode the password
        byte[] decodedPassword = Base64.getDecoder().decode(password);
        String decodedPasswordString = new String(decodedPassword);

        // Validate the user
        User user = userRepository.findUserByUsernameAndPassword(username, decodedPasswordString);
        if(user == null) {
            // In real world application, you'd want to handle this more gracefully
            // For example, you might want to throw an exception or return an error response
            throw new SecurityException("Invalid username or password");
        }
        return user;
    }
}