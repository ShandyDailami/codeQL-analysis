public class java_13635_CredentialValidator_A08 {
    private String username;
    private String password;

    public java_13635_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validate() {
        // Here, you can add your custom logic for data validation,
        // For instance, you can check if the username is not null and
        // the password is at least 8 characters long.

        // Here, I am just checking if they entered valid data,
        // you can add more checks as per your requirements.

        if (username == null || password == null) {
            return false;
        }

        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        if (username.length() < 5 || password.length() < 8) {
            return false;
        }

        // If all checks pass, return true
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.validate());
    }
}