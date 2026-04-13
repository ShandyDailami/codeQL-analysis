import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27135_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/access.txt"); // replace with your file
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // here is where you'd implement your security-sensitive operations, e.g., check if the user has a specific permission
            // but for simplicity, we'll just print the line
            System.out.println("Line: " + line);
        }

        scanner.close();
    }
}