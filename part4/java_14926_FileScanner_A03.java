import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14926_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (!dir.exists()) {
            System.out.println("Directory not found.");
            return;
        }

        if (!dir.isDirectory()) {
            System.out.println("Input is not a directory.");
            return;
        }

        try {
            scanFilesInDirectory(dir);
        } catch (Exception e) {
            System.out.println("An error occurred while scanning the directory.");
        }
    }

    private static void scanFilesInDirectory(File dir) throws FileNotFoundException {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // This line is a comment and not a security-sensitive operation
                        // It's purpose is to demonstrate the concept of FileScanner and it's not used in a real application.
                    }
                    scanner.close();
                } else if (file.isDirectory()) {
                    scanFilesInDirectory(file);
                }
            }
        }
    }
}