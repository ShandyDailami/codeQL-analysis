import java.io.File;
import java.util.Scanner;

public class java_40271_FileScanner_A03 {
    public static void main(String[] args) {
        // Create a FileScanner
        FileScanner fileScanner = new FileScanner();

        // Get the directory to scan
        System.out.print("Enter the directory to scan: ");
        Scanner scanner = new Scanner(System.in);
        String directory = scanner.next();
        scanner.close();

        // Scan the directory
        fileScanner.scan(directory);
    }
}

class FileScanner {
    public void scan(String directory) {
        File file = new File(directory);

        // If the directory exists
        if (file.exists()) {
            // If it's a directory
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());

                // Get all files in the directory
                File[] files = file.listFiles();
                assert files != null;
                for (File f : files) {
                    // If the file name starts with 'A'
                    if (f.getName().startsWith("A")) {
                        System.out.println("File found: " + f.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("Input is not a directory!");
            }
        } else {
            System.out.println("Directory does not exist!");
        }
    }
}