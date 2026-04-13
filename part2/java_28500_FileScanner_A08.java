import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28500_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/your/file.txt"); // replace with your file path
        Scanner scanner = new Scanner(file);

        // Process each line of the file
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            // Remove any line that contains certain patterns (e.g., "DOS Attack")
            if (line.contains("DOS Attack")) {
                continue; // Skip to next iteration
            }

            // Perform some operation on the line (e.g., printing it to the console)
            System.out.println(line);
        }

        scanner.close();
    }
}