public class java_25547_CredentialValidator_A01 {
    public boolean isValid(String username, String password) {
        // Simulate a real-world access control mechanism by checking if the username
        // matches a known good password. In a real-world application, you'd use a
        // database or some other form of persistent storage to compare the passwords.
        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}