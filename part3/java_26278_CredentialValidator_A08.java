import java.util.Base64;
import java.util.Scanner;

public class java_26278_CredentialValidator_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password:");
        String enteredPassword = scanner.next();

        // Get the password in bytes
        byte[] enteredPasswordBytes = enteredPassword.getBytes();

        // Encode the password in Base64
        byte[] passwordBytes = "Y2hhbmdlaG9zZWMi".getBytes();

        if (areEqual(enteredPasswordBytes, passwordBytes)) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }

    private static boolean areEqual(byte[] a, byte[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}