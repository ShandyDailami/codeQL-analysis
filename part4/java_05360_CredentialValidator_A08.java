public class java_05360_CredentialValidator_A08 {

    // Function to check if the given password matches the expected password
    public static boolean validatePassword(String inputPassword, String expectedPassword) {
        return inputPassword.equals(expectedPassword);
    }

    // Main method
    public static void main(String[] args) {

        // Provided password
        String expectedPassword = "12345";

        // Input password from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your password:");
        String inputPassword = scanner.nextLine();

        // Validate password
        if (validatePassword(inputPassword, expectedPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied. Incorrect password.");
        }

        // Close scanner
        scanner.close();
    }
}