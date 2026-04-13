public class java_23428_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_23428_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Some security-sensitive operation here...
        // Here, I am just checking if the username and password are not null
        // You would normally use a database or a real authentication service
        if (username == null || password == null) {
            return false;
        }

        // More security-sensitive operations here...

        return true;
    }
}

public class Service {
    private CredentialValidator validator;

    public java_23428_CredentialValidator_A03(CredentialValidator validator) {
        this.validator = validator;
    }

    public void doSomething() {
        // Calling the validate method on the validator
        if (validator.validate()) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}