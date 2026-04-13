public class java_00816_CredentialValidator_A01 {

    public boolean validate(String username, String password) {
        // Check if username starts with 'admin'
        if (!username.startsWith("admin")) {
            System.out.println("Invalid username. Username must start with 'admin'.");
            return false;
        }

        // Check if password is 'password'
        if (!password.equals("password")) {
            System.out.println("Invalid password. Password must be 'password'.");
            return false;
       
        }

        System.out.println("Credentials are valid.");
        return true;
    }
}