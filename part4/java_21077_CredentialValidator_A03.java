import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.credential.Credential;
import javax.security.auth.login.LoginException;

import java.security.Guard;
import java.security.GuardSyntax;

public class java_21077_CredentialValidator_A03 implements CredentialValidator {

    private Guard guard;

    public java_21077_CredentialValidator_A03(Guard guard) {
        this.guard = guard;
    }

    @Override
    public CredentialValidationResult validate(Subject subject, Credential credential) {
        // Create a custom credential
        CustomCredential customCredential = new CustomCredential(credential.getCredentialIdentifier(), credential.getCredentials());

        // Validate the credential
        if (guard.validate(customCredential)) {
            return new CredentialValidationResult("Credentials are valid", null);
        } else {
            return new CredentialValidationResult("Credentials are not valid", null);
        }
    }

    public class CustomCredential implements Credential {

        private String identifier;
        private char[] credentials;

        public java_21077_CredentialValidator_A03(String identifier, char[] credentials) {
            this.identifier = identifier;
            this.credentials = credentials;
        }

        @Override
        public String getCredentialIdentifier() {
            return identifier;
        }

        @Override
        public char[] getCredentials() {
            return credentials;
        }
    }

    public class CredentialValidationResult {

        private String status;
        private GuardSyntax syntax;

        public java_21077_CredentialValidator_A03(String status, GuardSyntax syntax) {
            this.status = status;
            this.syntax = syntax;
        }

        public String getStatus() {
            return status;
        }

        public GuardSyntax getSyntax() {
            return syntax;
        }
    }
}