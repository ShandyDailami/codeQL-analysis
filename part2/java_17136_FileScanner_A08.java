import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_17136_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_file.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            // TODO: Add your security-sensitive operation here.
            // For instance, check if line contains password or key.
            if (line.contains("password") || line.contains("key")) {
                System.out.println("Integrity failure detected in file: " + file.getName());
                // TODO: Add your security-sensitive operation here.
                // For instance, print the line or even terminate the program.
                System.out.println("Security alert! File content: " + line);
                System.exit(1);
            }
        }
        scanner.close();
    }
}