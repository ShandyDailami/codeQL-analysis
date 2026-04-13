public class java_16025_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_16025_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        return this.username.equals(this.password);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("test", "test");
        if (validator.validate()) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}