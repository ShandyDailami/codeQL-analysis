import java.io.File;
import java.util.Scanner;

public class java_38462_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            scanFilesInDirectory(directory);
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }

        scanner.close();
    }

    private static void scanFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // This is a secure operation related to A07_AuthFailure
                    // For example, we could check if the file has a '.txt' extension
                    if (file.getName().endsWith(".txt")) {
                        System.out.println("Found a .txt file: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    // Recursively scan the subdirectory
                    scanFilesInDirectory(file);
                }
            }
        }
    }
}