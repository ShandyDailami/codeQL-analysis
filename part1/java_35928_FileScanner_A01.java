import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35928_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Please enter the file name: ");
        String fileName = scanner.nextLine();

        File file = new File(directoryPath, fileName);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                // This is a security-sensitive operation, as it could potentially read the file content
                System.out.println("Found line: " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}