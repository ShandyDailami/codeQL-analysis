import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class java_37777_CredentialValidator_A01 {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void validateCredentials(String userName, String password) {
        // Assuming you have a UserRepository which is used to get user details
        // and a UserService which is used to validate the passwords.
        // Assuming we have a User object with a username and password field
        // UserRepository.findByUsername(userName);
        // UserService.validatePassword(userPassword, foundUser.getPassword());

        // Here, we are just checking if the passwords match
        // You should replace this with actual logic to validate the password

        if (passwordEncoder.matches(password, "hashedPassword")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}