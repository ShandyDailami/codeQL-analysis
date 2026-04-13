import javax.swing.JOptionPane;

public class java_10818_CredentialValidator_A03 {

    public static void main(String[] args) {
        String username = JOptionPane.showInputDialog("Enter your username:");
        String password = JOptionPane.showInputDialog("Enter your password:");
        
        if (validate(username, password)) {
            JOptionPane.showMessageDialog(null, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password!");
        }
    }

    private static boolean validate(String username, String password) {
        // For the sake of simplicity, we're going to hardcode the username and password here.
        // In a real application, you'd want to use a secure method of storing credentials.
        String correctUsername = "admin";
        String correctPassword = "password";

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}