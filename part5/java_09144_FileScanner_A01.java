import java.io.File;
import java.util.Scanner;

public class java_09144_FileScanner_A01 {
    private static final String ROOT_DIR = "C:/";
    private static final String SEARCH_EXTENSION = "*.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File rootDir = new File(dirPath);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.out.println("Invalid directory path. Please try again.");
            return;
        }

        File[] files = rootDir.listFiles(file -> file.isFile() && (file.getName().endsWith(SEARCH_EXTENSION)));
        if (files == null) {
            System.out.println("No files with the specified extension found in the directory.");
            return;
        }

        for (File file : files) {
            if (file.getName().endsWith(".txt")) {
                System.out.println("File: " + file.getName());
            }
        }
    }
}