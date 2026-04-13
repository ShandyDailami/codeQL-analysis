public class java_05722_CredentialValidator_A03 {
    private String knownUsername;
    private String knownPassword;

    public java_05722_CredentialValidator_A03(String knownUsername, String knownPassword) {
        this.knownUsername = knownUsername;
        this.knownPassword = knownPassword;
    }

    public boolean validate(String username, String password) {
        return username.equals(this.knownUsername) && password.equals(this.knownPassword);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");

        if(validator.validate("admin", "password")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}