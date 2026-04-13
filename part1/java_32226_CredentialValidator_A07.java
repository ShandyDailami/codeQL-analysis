import java.security.Principal;

public class java_32226_CredentialValidator_A07 {
    private String secret;

    public java_32226_CredentialValidator_A07(String secret) {
        this.secret = secret;
    }

    public boolean validate(Principal principal) {
        if (principal == null) {
            return false;
        }
        if (principal.getName() == null) {
            return false;
        }
        if (secret == null) {
            return false;
        }
        return principal.getName().equals(secret);
    }

    public static void main(String[] args) {
        String secret = "admin";
        Principal principal = new Principal() {
            public String getName() {
                return secret;
            }
        };
        CustomCredentialValidator validator = new CustomCredentialValidator(secret);
        boolean isValid = validator.validate(principal);
        System.out.println("Is valid: " + isValid);
    }
}