public class java_12841_CredentialValidator_A01 {
    private String knownUsername;
    private String knownPassword;

    public java_12841_CredentialValidator_A01(String username, String password) {
        this.knownUsername = username;
        this.knownPassword = password;
    }

    public boolean validateCredentials(String username, String password) {
        return username.equals(this.knownUsername) && password.equals(this.knownPassword);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        
        if (validator.validateCredentials("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}