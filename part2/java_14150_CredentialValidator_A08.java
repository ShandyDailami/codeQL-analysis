public class java_14150_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_14150_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Here, we'll just check if the username and password are not null or empty.
        // This is a very simplistic approach and should not be used in a real-world application.
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        // For the sake of simplicity, we'll just check if the username is 'admin' and the password is 'password'.
        // In a real-world application, you should use a more secure way to check credentials.
        return username.equals("admin") && password.equals("password");
    }
}