import java.util.Base64;

public class java_23904_CredentialValidator_A03 {

    // A list of hard-coded valid credentials
    private static final String[][] VALID_CREDENTIALS = {
            {"alice", "password1"},
            {"bob", "password2"},
            {"charlie", "password3"},
            {"dave", "password4"}
    };

    // Method to check the username and password against a hard-coded set
    public boolean validate(String username, String password) {
        String enteredCredentials = username + ":" + password;
        String hardCodedCredentials = new String(Base64.getDecoder().decode(VALID_CREDENTIALS[0][0] + ":" + VALID_CREDENTIALS[0][1]));
        
        return enteredCredentials.equals(hardCodedCredentials);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("alice", "password1")); // should print true
        System.out.println(validator.validate("alice", "wrong")); // should print false
    }
}