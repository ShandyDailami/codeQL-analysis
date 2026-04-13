import java.util.Scanner;

public class java_30582_CredentialValidator_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get username from user
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        
        // Get password from user
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        
        // Validate username and password
        if (validateCredentials(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
        
        scanner.close();
    }
    
    // Private method that performs the actual validation
    private static boolean validateCredentials(String username, String password) {
        // Replace this with your actual logic to validate the credentials
        // For this example, we'll assume if the username is "admin" and the password is "password", access is granted
        return username.equals("admin") && password.equals("password");
    }
}