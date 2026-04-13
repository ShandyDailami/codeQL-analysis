import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18801_FileScanner_A07 {
    public static void main(String[] args) {
        // Read the file path from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        // Check if the file exists
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        // Check if the file is empty
        if (file.length() == 0) {
            System.out.println("File is empty");
        } else {
            System.out.println("File is not empty");
        }

        scanner.close();
    }
}