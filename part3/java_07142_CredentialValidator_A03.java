public class java_07142_CredentialValidator_A03 {
    // validate method that takes in username and password
    public boolean validate(String username, String password) {
        // This is a very basic validation. For real-world applications,
        // you would likely want to use a more sophisticated method
        // of checking the credentials.

        // For simplicity, we'll just check if the username is not null
        // and if the password is not null. This is just a placeholder,
        // in a real application you would not do this.
        if (username == null || password == null) {
            return false;
        }

        // Check if the username is "admin" and the password is "password".
        // In a real application, you would use a hashing method
        // to compare the passwords.
        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        }

        return false;
    }
}