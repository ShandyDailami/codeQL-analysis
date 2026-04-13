public interface Validator {
    boolean isValid(String username, String password);
}

public class java_08808_CredentialValidator_A01 implements Validator {
    private String[] validUsers;
    private String[] validPasswords;

    public java_08808_CredentialValidator_A01() {
        this.validUsers = new String[]{"user1", "user2", "user3"};
        this.validPasswords = new String[]{"password1", "password2", "password3"};
    }

    @Override
    public boolean isValid(String username, String password) {
        if(username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }

        for(int i = 0; i < validUsers.length; i++) {
            if(validUsers[i].equals(username) && validPasswords[i].equals(password)) {
                return true;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Validator validator = new UserValidator();

        String username = "user1";
        String password = "password1";

        if(validator.isValid(username, password)) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are invalid.");
        }
    }
}