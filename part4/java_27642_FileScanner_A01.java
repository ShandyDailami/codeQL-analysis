import java.io.File;
import java.util.Scanner;

public class java_27642_FileScanner_A01 {

    public static void main(String[] args) {

        // Create a FileScanner instance
        FileScanner fileScanner = new FileScanner();

        // Prompt user for directory path
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        // Scan directory for files
        File directory = new File(dirPath);
        String[] fileList = directory.list();

        if (fileList != null) {
            for (String fileName : fileList) {
                System.out.println(fileName);
            }
        } else {
            System.out.println("Directory not found.");
        }

        // Close scanner
        scanner.close();
    }
}

class FileScanner {

    public String[] list(String dirPath) {
        return new String[0];
    }
}