public class java_40454_CredentialValidator_A03 {

    private String validUsername;
    private String validPassword;

    public java_40454_CredentialValidator_A03(String validUsername, String validPassword) {
        this.validUsername = validUsername;
        this.validPassword = validPassword;
    }

    public boolean validateCredentials(String username, String password) {
        return (username.equals(validUsername) && password.equals(validPassword));
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        
        if(validator.validateCredentials("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}