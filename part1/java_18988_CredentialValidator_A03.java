public class java_18988_CredentialValidator_A03 {
    private String username;
    private String password;

    public java_18988_CredentialValidator_A03(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class CredentialValidator {
    public boolean validate(Credentials credentials) {
        if (credentials.getPassword().length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;

        for (char c : credentials.getPassword().toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }

            if (hasUpperCase && hasLowerCase && hasDigit) {
                return true;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        Credentials credentials = new Credentials("user123", "Password1!@#");

        if (validator.validate(credentials)) {
            System.out.println("Credentials validated successfully");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}