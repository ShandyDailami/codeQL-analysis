import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38126_FileScanner_A07 {

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/authFailureFile.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Perform security-related operations here
                // For example, print the line
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}