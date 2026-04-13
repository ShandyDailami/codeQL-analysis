import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34905_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here you should use a secure method to check if the line contains the specific access control violation.
                // For now, let's say that we just read the file and print it.
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}