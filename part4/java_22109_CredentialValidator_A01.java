public class java_22109_CredentialValidator_A01 {
    private List<String> allowedUsers;

    public java_22109_CredentialValidator_A01() {
        allowedUsers = new ArrayList<>();
        // Add some default allowed users
        allowedUsers.add("user1");
        allowedUsers.add("user2");
        allowedUsers.add("user3");
    }

    public boolean isValid(String user) {
        return allowedUsers.contains(user);
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator(new UserValidator());

        // Test access with valid credentials
        if (validator.isValid("user1")) {
            System.out.println("Access granted for user1");
        } else {
            System.out.println("Access denied for user1");
        }

        // Test access with invalid credentials
        if (validator.isValid("user4")) {
            System.out.println("Access granted for user4");
        } else {
            System.out.println("Access denied for user4");
        }
    }
}

public class CredentialValidator {
    private UserValidator validator;

    public java_22109_CredentialValidator_A01(UserValidator validator) {
        this.validator = validator;
    }

    public boolean isValid(String user) {
        return validator.isValid(user);
    }
}