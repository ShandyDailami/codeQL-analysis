public class java_37314_CredentialValidator_A07 {
    private String name;
    private String password;

    public java_37314_CredentialValidator_A07(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}

public interface CredentialValidator {
    User validate(String userName, String password);
}

public class LegacyCredentialValidator implements CredentialValidator {

    private User[] users = {
        new User("Alice", "password1"),
        new User("Bob", "password2"),
        new User("Charlie", "password3")
    };

    @Override
    public User validate(String userName, String password) {
        for (User user : users) {
            if (user.getName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        CredentialValidator validator = new LegacyCredentialValidator();

        User user = validator.validate("Alice", "password1");
        if (user != null) {
            System.out.println("Welcome, " + user.getName());
        } else {
            System.out.println("Invalid credentials");
        }
    }
}