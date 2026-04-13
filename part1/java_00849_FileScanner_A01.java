import java.io.File;
import java.util.Scanner;

public class java_00849_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            scanDirectory(directory);
        } else {
            System.out.println("Invalid directory path!");
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }
    }
}