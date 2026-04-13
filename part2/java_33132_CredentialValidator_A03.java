public class java_33132_CredentialValidator_A03 {
    public boolean validateCredentials(String userName, String password) {
        // In a real application, you would typically use an external database or library
        // to fetch user credentials from a user table. For the sake of simplicity, we'll just 
        // return true for a known username and password.

        if ("admin".equals(userName) && "password".equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}