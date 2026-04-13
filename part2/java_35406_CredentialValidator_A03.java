public class java_35406_CredentialValidator_A03 {

    private String username;
    private String password;

    public java_35406_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid() {
        return this.username.equals("admin") && this.password.equals("password");
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.isValid());
    }
}