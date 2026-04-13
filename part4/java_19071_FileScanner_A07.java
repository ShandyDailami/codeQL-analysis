import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19071_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/auth.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // TODO: Process the line for security-sensitive operations.
                // For now, just print the line.
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please ensure the file is located in the specified location.");
        }
    }
}