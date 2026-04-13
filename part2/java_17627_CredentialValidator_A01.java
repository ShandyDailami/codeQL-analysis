public class java_17627_CredentialValidator_A01 {
    private String username;
    private String password;

    public java_17627_CredentialValidator_A01(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Simulating access control by checking if the username matches the hard-coded pattern
        return (username.equals("admin") && password.equals("password"));
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        if (validator.validate()) {
            System.out.println("Credentials are valid!");
        } else {
            System.out.println("Invalid credentials!");
        }
    }
}