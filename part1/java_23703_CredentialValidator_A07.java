// import necessary libraries
import java.security.Principal;
import java.util.ArrayList;

// credential validator example
public class java_23703_CredentialValidator_A07 {

    private ArrayList<Principal> authorizedUsers;

    // constructor
    public java_23703_CredentialValidator_A07() {
        authorizedUsers = new ArrayList<>();
    }

    // method to add authorized user
    public void addAuthorizedUser(Principal user) {
        authorizedUsers.add(user);
    }

    // method to validate credential
    public boolean validateCredential(String username, String password) {
        // check if user is authorized
        for (Principal user : authorizedUsers) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }

        // if user is not authorized, fail the authentication
        System.out.println("Authentication failed!");
        return false;
    }

    // main method
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // add authorized users
        validator.addAuthorizedUser(new Principal() {
            public String getName() {
                return "user1";
            }

            public String getPassword() {
                return "password1";
            }
        });

        validator.addAuthorizedUser(new Principal() {
            public String getName() {
                return "user2";
            }

            public String getPassword() {
                return "password2";
            }
        });

        // validate credentials
        if (validator.validateCredential("user1", "password1")) {
            System.out.println("User authenticated successfully!");
        }

        if (validator.validateCredential("user3", "password3")) {
            System.out.println("User authenticated successfully!");
        }
    }
}