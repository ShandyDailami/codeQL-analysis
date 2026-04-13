public class java_00985_CredentialValidator_A03 {
    private boolean isValidUsername(String username) {
        // Here, we're just checking if the username is null or empty. 
        // In a real application, you'd also want to compare against a database or other security source.
        return username != null && !username.isEmpty();
    }

    private boolean isValidPassword(String password) {
        // Here, we're just checking if the password is null or empty. 
        // In a real application, you'd also want to compare against a database or other security source.
        return password != null && !password.isEmpty();
    }

    public boolean validateCredentials(String username, String password) {
        if (!isValidUsername(username) || !isValidPassword(password)) {
            System.out.println("Invalid username or password.");
            return false;
        }
        
        // Here, we're just checking if the username is "admin" and the password is "password". 
        // In a real application, you'd compare against a database or other security source.
        if ("admin".equals(username) && "password".equals(password)) {
            System.out.println("Login successful.");
            return true;
        } else {
            System.out.println("Invalid username or password.");
            return false;
        }
    }
}