import java.io.File;
import java.util.Scanner;

public class java_15166_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            scanDirectory(directory, scanner);
        } else {
            System.out.println("Invalid directory path!");
        }
    }

    private static void scanDirectory(File directory, Scanner scanner) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file, scanner);
                } else {
                    // This is a file, so we can't break the law.
                    // SecurityScanner checks if the file is safe.
                    if (isSafeFile(file)) {
                        System.out.println("Safe file: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }

    private static boolean isSafeFile(File file) {
        // This is a placeholder for your security check.
        // You can replace this with your actual security check.
        return false;
    }
}