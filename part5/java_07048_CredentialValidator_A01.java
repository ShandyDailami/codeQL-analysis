public class java_07048_CredentialValidator_A01 {
    public static boolean validate(String username, String password) {
        // For simplicity, let's hardcode the username and password. In a real application, 
        // you would want to fetch these values from a database or another source.
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            return true; // Authentication successful
        } else {
            return false; // Authentication failed
        }
    }

    public static void main(String[] args) {
        String hardcodedUsername = "admin";
        String hardcodedPassword = "password";

        System.out.println("Enter username:");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        if (validate(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}