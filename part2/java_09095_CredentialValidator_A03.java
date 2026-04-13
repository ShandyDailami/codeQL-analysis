public class java_09095_CredentialValidator_A03 {

    private String requiredString;

    public java_09095_CredentialValidator_A03(String requiredString) {
        this.requiredString = requiredString;
    }

    public boolean validate(String password) {
        if (password == null) {
            return false;
        }
        if (password.contains(requiredString)) {
            return false;
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        CustomCredentialValidator validator = new CustomCredentialValidator("password");
        String password = "myPassword";
        if (validator.validate(password)) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
    }
}