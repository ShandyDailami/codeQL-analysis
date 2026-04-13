public class java_00167_CredentialValidator_A08 {
    private String correctUsername;
    private String correctPassword;

    public java_00167_CredentialValidator_A08() {
        this.correctUsername = "admin";
        this.correctPassword = "password";
    }

    public boolean validate(String username, String password) {
        if (username.equals(this.correctUsername) && password.equals(this.correctPassword)) {
            System.out.println("Access granted!");
            return true;
        } else {
            System.out.println("Access denied!");
            return false;
        }
    }
}