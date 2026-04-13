import java.io.File;
import java.util.Scanner;

public class java_42143_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);

        // Attempt to open the file without the necessary permissions
        try {
            Scanner fileScanner = new Scanner(file);

            // In a security-sensitive operation, we'll just print out each line of the file
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }

            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Unable to open the file: " + e.getMessage());
        }

        scanner.close();
    }
}