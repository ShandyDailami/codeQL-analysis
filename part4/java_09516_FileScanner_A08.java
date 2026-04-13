import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09516_FileScanner_A08 {

    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("sample.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // Assume that the file's integrity is being checked here for any line that contains a certain string
                if (line.contains("A08_IntegrityFailure")) {
                    System.out.println("Line contains 'A08_IntegrityFailure': " + line);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}