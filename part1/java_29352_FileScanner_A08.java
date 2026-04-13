import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29352_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        // Prompt user for directory path
        System.out.println("Enter a directory path:");
        Scanner scanner = new Scanner(System.in);
        String dirPath = scanner.nextLine();

        // Create FileScanner
        File dir = new File(dirPath);
        FileScanner scannerFile = new FileScanner(dir);

        // List files in directory
        System.out.println("Files in directory:");
        while (scannerFile.hasNext()) {
            File file = scannerFile.nextFile();
            System.out.println(file.getName());
        }

        // Close FileScanner
        scannerFile.close();
    }
}