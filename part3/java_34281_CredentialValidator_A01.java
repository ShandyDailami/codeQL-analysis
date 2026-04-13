// CredentialValidator is a basic interface that requires a method for authenticating a user.
interface CredentialValidator {
    boolean validate(String username, String password);
}

// CredentialValidatorImpl is a concrete class java_34281_CredentialValidator_A01 implements the CredentialValidator interface.
class CredentialValidatorImpl implements CredentialValidator {
    private String[][] credentials = {{"user1", "password1"}, {"user2", "password2"}, {"user3", "password3"}};

    // validate method checks if the given username and password match with the pre-defined ones.
    public boolean validate(String username, String password) {
        for(int i = 0; i < credentials.length; i++) {
            if(credentials[i][0].equals(username) && credentials[i][1].equals(password)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator credentialValidator = new CredentialValidatorImpl();
        // Test the validate method.
        System.out.println(credentialValidator.validate("user1", "password1")); // Should print true.
        System.out.println(credentialValidator.validate("user1", "wrongPassword")); // Should print false.
    }
}