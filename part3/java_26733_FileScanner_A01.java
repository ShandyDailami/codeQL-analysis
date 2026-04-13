import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_26733_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the file name to search:");
        String fileName = scanner.nextLine();

        try {
            File dir = new File(dirPath);
            File file = new File(dir, fileName);
            if (!file.exists()) {
                System.out.println("File not found!");
                return;
            }
            if (file.isDirectory()) {
                System.out.println("It's a directory, not a file!");
                return;
            }
            if (!file.canRead()) {
                System.out.println("You don't have permission to read this file!");
                return;
            }
            if (file.length() == 0) {
                System.out.println("The file is empty!");
                return;
            }

            System.out.println("File found!");
            // Start of code
            // FileScanner implementation goes here
            // ...
            // End of code
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } finally {
            scanner.close();
        }
    }
}