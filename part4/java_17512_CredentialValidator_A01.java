import java.util.HashSet;
import java.util.Set;

public class java_17512_CredentialValidator_A01 implements CredentialValidator {

    private Set<String> authorizedUsers;

    public java_17512_CredentialValidator_A01() {
        authorizedUsers = new HashSet<String>();
        // Add some initial users here (e.g., set them up in a database or an external file)
        authorizedUsers.add("user1");
        authorizedUsers.add("user2");
        authorizedUsers.add("user3");
    }

    @Override
    public boolean validate(String user, String password) {
        // Here we're just checking if the user is in our list of authorized users
        // In a real-world application, you'd want to hash and salt passwords, 
        // check against a stored hash and compare the salts too
        return authorizedUsers.contains(user);
    }
}