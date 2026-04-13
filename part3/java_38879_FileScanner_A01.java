import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38879_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("file.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here we're assuming a password is just one word per line.
                // In real-world scenarios, passwords might be longer and complex.
                // We're also not checking if the password is valid or not (for simplicity).
                String password = line.trim();
                // Here we're just printing the password.
                // In real-world scenarios, you'd replace this with some sort of security operation.
                System.out.println("Password found: " + password);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file path.");
        }
    }
}