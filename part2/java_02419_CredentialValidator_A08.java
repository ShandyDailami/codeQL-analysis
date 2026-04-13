public class java_02419_CredentialValidator_A08 {

    private String realPassword;

    public java_02419_CredentialValidator_A08(String password) {
        this.realPassword = password;
    }

    public boolean validatePassword(String password) {
        return this.realPassword.equals(password);
    }
}

public class Main {
    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator("secret");
        System.out.println(validator.validatePassword("wrongPassword")); // false
        System.out.println(validator.validatePassword("secret")); // true
    }
}