public class java_09318_CredentialValidator_A08 {

    private String userName;
    private String password;

    public java_09318_CredentialValidator_A08(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean validate() {
        // Simulate a long running operation to check if the username and password match
        // For instance, we are just checking if the user is admin and the password is 'admin'
        if ("admin".equals(userName) && "admin".equals(password)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "admin");
        if (validator.validate()) {
            System.out.println("Credentials are valid");
        } else {
            System.out.println("Credentials are invalid");
        }
    }
}