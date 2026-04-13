import java.security.Principal;
import java.security.credential.Credential;
import java.security.credential.CredentialSubject;
import java.util.Arrays;

public class java_18489_CredentialValidator_A07 {
    public boolean validate(Credential credential) {
        // Check if credential is null
        if (credential == null) {
            System.out.println("Credential is null");
            return false;
        }

        // Check if credential subject is null
        CredentialSubject credentialSubject = credential.getCredentialSubject();
        if (credentialSubject == null) {
            System.out.println("Credential subject is null");
            return false;
        }

        // Check if principal is null
        Principal principal = credentialSubject.getPrincipal();
        if (principal == null) {
            System.out.println("Principal is null");
            return false;
        }

        // Check if credentials is null
        Credential.CredentialStatus status = credential.getStatus();
        if (status == null) {
            System.out.println("Status is null");
            return false;
        }

        // Check if password is correct
        String[] passwords = credential.getPassword();
        if (passwords == null || passwords.length == 0) {
            System.out.println("Password is null or empty");
            return false;
        }

        if (!Arrays.equals(passwords, new String[] {"correctPassword"})) {
            System.out.println("Wrong password");
            return false;
        }

        return true;
    }
}