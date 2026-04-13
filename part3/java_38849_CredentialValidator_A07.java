import java.security.Principal;

public class java_38849_CredentialValidator_A07 {
    public static boolean validateCredential(String username, String password) {
        // Stubbed out for the sake of simplicity
        // In a real application, this would involve checking against a database or other source
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Principal principal = new UserPrincipal("admin");
        boolean isValidated = SimpleCredentialValidator.validateCredential(principal.getName(), "password");
        if (isValidated) {
            System.out.println("User is authenticated successfully!");
        } else {
            System.out.println("Invalid credentials, access denied!");
        }
    }
}

class UserPrincipal implements Principal {
    private String name;

    public java_38849_CredentialValidator_A07(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}