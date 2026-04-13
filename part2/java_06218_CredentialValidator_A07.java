// CredentialValidator example in vanilla Java

import java.util.Base64;

public class java_06218_CredentialValidator_A07 {

    private String[] hardCodedCredentials = {"user1:password1", "user2:password2", "user3:password3"};

    public boolean validate(String username, String password) {
        String decodedCredential = new String(Base64.getDecoder().decode(username));
        String decodedPassword = new String(Base64.getDecoder().decode(password));

        if (isCredentialValid(decodedCredential, decodedPassword)) {
            return true;
        }

        return false;
    }

    private boolean isCredentialValid(String username, String password) {
        for (String credential : hardCodedCredentials) {
            String[] userCredential = credential.split(":");

            if (userCredential[0].equals(username) && userCredential[1].equals(password)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String user1Credential = Base64.getEncoder().encodeToString("user1:password1".getBytes());
        String user2Credential = Base64.getEncoder().encodeToString("user2:password2".getBytes());
        String user3Credential = Base64.getEncoder().encodeToString("user3:password3".getBytes());

        System.out.println(validator.validate(user1Credential, user2Credential)); // Expects false
        System.out.println(validator.validate(user1Credential, user3Credential)); // Expects true
    }
}