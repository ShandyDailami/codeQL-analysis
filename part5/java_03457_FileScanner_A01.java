import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03457_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("C:\\path\\to\\file"));

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            // Remove comment by replacing line starting with '#'
            if (line.trim().startsWith("#")) {
                line = line.trim().replaceFirst("#", "");
            }

            // Now, you can perform security-sensitive operations on the line
            // For example, check if the line contains a specific string
            if (line.contains("sensitiveString")) {
                // If the line contains the specific string, print a warning message
                System.out.println("Warning: Sensitive data detected in file!");
            }
        }

        fileScanner.close();
    }
}