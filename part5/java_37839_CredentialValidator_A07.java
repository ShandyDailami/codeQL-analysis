import java.util.HashMap;
import java.util.Map;

public class java_37839_CredentialValidator_A07 {

    // This is a simple data model, in a real application
    // we'd likely have a database or other persistent store to retrieve users and roles.
    private Map<String, String> userToRoleMap = new HashMap<>();

    {
        userToRoleMap.put("user", "ROLE_USER");
        userToRoleMap.put("admin", "ROLE_ADMIN");
    }

    public boolean validateCredentials(String username, String password) {
        // A real application would compare the password to a hashed version of the password
        // that is stored in the database. The hash method to use will depend on the
        // specifics of your application.
        String expectedRole = userToRoleMap.get(username);
        if (expectedRole == null) {
            return false;
        }

        // A simple check for the user's role
        return expectedRole.equals("ROLE_ADMIN") && password.equals("admin_password");
    }
}