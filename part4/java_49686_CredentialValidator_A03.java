import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Arrays;
import java.util.List;

public class java_49686_CredentialValidator_A03 {
    private List<User> users = Arrays.asList(new User("user", new BCryptPasswordEncoder().encode("password")),  // replace with actual user information from a real database or external source, for simplicity sake we use hardcoded passwords here  
                                                new User ("admin", new BCryptPasswordEncoder().encode("admin")));     // same as above but the admin account can access all functionalities of our app. (for A03_Injection)  Here it is not recommended to store actual user information, this should be stored securely in a real database or external source
	        
    public boolean validateUser(String username, String password){ //A function that validates the entered login credentials against those saved within our users list. (for A03_Injection) Here it is not recommended to use actual user information for validation like this as we need real database access here which cannot be performed via Spring Security in Java
        return users.stream().anyMatch(user -> username.equals(user.getUsername()) &&  //A function that checks if the entered login credentials match those saved within our User list (for A03
                                                new BCryptPasswordEncoder().matches(password, user.getPassword()));   ///This matches method from Spring's password encoder is used to verify whether we have a correct hashed version of plaintext provided in function argument against one stored previously for this specific username)  */
    } //end User class (for A03_Injection and Security concerns, better practice would be storing user information securely like email addresses or phone numbers instead than usernames). Spring security uses these to verify credentials. In a real app you will need actual database access not just hardcoded passwords
}  //end AuthenticationService class (for A03_Injection and Security concerns)