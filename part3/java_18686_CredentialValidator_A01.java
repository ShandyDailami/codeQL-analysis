public class java_18686_CredentialValidator_A01 {

    private String[] validUsers = {"user1", "user2", "user3"};

    public boolean validate(String username, String password) {
        // In a real-world application, this method would hash the password,
        // compare the hashed password to the stored hashed password, 
        // and return a boolean result.
        
        // For the sake of simplicity, we'll just check if the password 
        // is "password" for all users. In a real-world application, 
        // you would also need to compare the username with a list of allowed 
        // users to prevent unauthorized access.
        return password.equals("password") && containsUser(username);
    }

    private boolean containsUser(String username) {
        for (String validUser : validUsers) {
            if (validUser.equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("user1", "password"));  // Outputs: true
        System.out.println(validator.validate("user4", "password"));  // Outputs: false
    }
}