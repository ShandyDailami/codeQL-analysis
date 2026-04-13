import java.util.HashMap;
import java.util.Map;

public class java_18757_CredentialValidator_A03 {

    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
    }

    public static class CredentialValidator implements javax.security.auth.CredentialValidator {

        @Override
        public javax.security.auth.CredentialValidationResult validate(javax.security.auth.Credential credential) {

            String username = credential.getIdentifier();
            String password = credential.getBadPwdCount() + "";

            if (users.containsKey(username) && users.get(username).equals(password)) {
                return new javax.security.auth.CredentialValidationResult("Success", null);
            } else {
                return new javax.security.auth.CredentialValidationResult("Failure", null);
            }
        }
    }

    public static void main(String[] args) {
        javax.security.auth.LoginContext loginContext = new javax.security.auth.LoginContext("MyRealm");
        loginContext.setCallerPrincipal(new javax.security.auth.Subject("myUser"));
        loginContext.setCredentials(new javax.security.auth.UsernamePasswordCredential("user1", "password1"));

        try {
            javax.security.auth.Subject subject = loginContext.getSubject();
            subject.getPrincipal();
            subject.getPrivateCredentials();
            subject.getAuthQualifiers();
            subject.getTransientCredentials();
            subject.getOrderedCredentials();
            subject.getRealm();
            subject.getCredentials();
            subject.getPublicCredentials();
            subject.getAuthQualifiers();
            subject.getOrderedCredentials();
            subject.getPrivateCredentials();
            subject.getTransientCredentials();
            subject.getRealm();
            subject.getAuthQualifiers();
            subject.getCredentials();
            subject.getPrivateCredentials();
            subject.getTransientCredentials();
            subject.getRealm();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}