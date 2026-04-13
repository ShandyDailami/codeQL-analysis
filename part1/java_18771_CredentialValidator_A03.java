public class java_18771_CredentialValidator_A03 {

    private String[] validUsers;

    public java_18771_CredentialValidator_A03() {
        validUsers = new String[] {"user1", "user2", "user3"}; // This is a placeholder. You should not store passwords in plain text.
    }

    public boolean validate(String username, String password) {
        for (String user : validUsers) {
            if (user.equals(username) && user.equals(password)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {

    public static void main(String[] args) {
        LegacyCredentialValidator validator = new LegacyCredentialValidator();
        
        System.out.println("Enter username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        
        if (validator.validate(username, password)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}