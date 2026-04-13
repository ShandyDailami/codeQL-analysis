import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10046_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        if (file.exists()) {
            if (file.canRead(file)) {
                Scanner fileScanner = new Scanner(file);

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println("Processing line: " + line);

                    // This is a security-sensitive operation, it should be removed
                    // in a real application
                    System.out.println("Malicious operation");

                    // This is another security-sensitive operation, it should be removed
                    // in a real application
                    System.out.println("Malicious operation");
                }

                fileScanner.close();
            } else {
                System.out.println("You do not have permission to read the file.");
            }
        } else {
            System.out.println("The file does not exist.");
        }

        scanner.close();
    }
}