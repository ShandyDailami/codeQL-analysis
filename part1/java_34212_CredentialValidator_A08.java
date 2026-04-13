public class java_34212_CredentialValidator_A08 {

    private String password;

    public java_34212_CredentialValidator_A08(String password) {
        this.password = password;
    }

    public boolean validate(String userPassword) {
        if (userPassword == null) {
            return false;
        }
        return userPassword.equals(this.password);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("password123");
        System.out.println(validator.validate("password123")); // should print true
        System.out.println(validator.validate("wrongPassword")); // should print false
    }
}