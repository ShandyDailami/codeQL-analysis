import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20043_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the file:");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        try {
            if (file.exists()) {
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    // This line is not used here, but it's considered a security-sensitive operation.
                    // You can use it for any operation related to authentication failure.
                }
                fileScanner.close();
            } else {
                System.out.println("File not found!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } finally {
            scanner.close();
        }
    }
}