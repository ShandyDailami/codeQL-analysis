public class java_09188_CredentialValidator_A08 {

    private String password;
    private String confirmedPassword;

    public java_09188_CredentialValidator_A08(String password, String confirmedPassword) {
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    public boolean isValid() {
        // In a real-world system, you would typically hash the password before comparing it to the hashed confirmed password
        // This is a simplified example and might not be secure enough for a production system
        return password.equals(confirmedPassword);
    }
}

public class Main {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("password", "password");
        System.out.println(validator.isValid()); // This will print true or false
   
        // This will compile and run successfully, without throwing an error
        CredentialValidator invalidValidator = new CredentialValidator("wrongPassword", "wrongPassword");
        System.out.println(invalidValidator.isValid()); // This will print false
    }
}