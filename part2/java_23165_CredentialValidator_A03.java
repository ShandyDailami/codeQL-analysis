import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class java_23165_CredentialValidator_A03 implements java.security.Authenticator.CredentialValidator {

    private List<String> validUsers;

    public java_23165_CredentialValidator_A03() {
        validUsers = Arrays.asList("user1", "user2", "user3");
    }

    @Override
    public boolean validate(String username, String password) {
        Predicate<String> isUserInList = s -> s.equals(username);
        return validUsers.stream().anyMatch(isUserInList);
    }
}

public class Main {
    public static void main(String[] args) {
        java.security.Authenticator auth = new java.security.Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("user4", "password4", "Custom Realm");
            }
        };

        // Set the authenticator for authentication
        java.security.Security.setSecurityManager(new MySecurityManager(auth));

        // Call the custom validator
        try {
            new CustomCredentialValidator().validate("user4", "password4");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MySecurityManager extends java.security.SecurityManager {
    private java.security.Authenticator auth;

    public java_23165_CredentialValidator_A03(java.security.Authenticator auth) {
        this.auth = auth;
    }

    @Override
    public java.security.Authentication getAuthentication() {
        return auth.getAuthentication();
    }
}