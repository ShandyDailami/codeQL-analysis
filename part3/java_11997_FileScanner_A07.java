import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_11997_FileScanner_A07 {
    private static final String HASHED_PASSWORD = "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd87cf1c62d1669c6ae4003c9a3";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password:");
        String inputPassword = scanner.nextLine();

        if (isPasswordValid(inputPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        scanner.close();
    }

    private static boolean isPasswordValid(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = messageDigest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashedPassword) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString().equals(HASHED_PASSWORD);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}