import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08597_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("example.txt"); // Replace with your file path
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here, we are just printing the line to the console.
                // In a real-world application, you would not print sensitive information.
                // This is just a simple example to demonstrate security-sensitive operations.
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}