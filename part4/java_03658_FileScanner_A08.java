import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03658_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path_to_your_file");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            // Perform security-sensitive operations here
            // For example, you can print the line to the console
            System.out.println(line);
        }

        scanner.close();
    }
}