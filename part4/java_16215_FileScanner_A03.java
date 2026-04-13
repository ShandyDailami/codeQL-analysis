import java.io.File;
import java.util.Scanner;

public class java_16215_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Print out the file name and its size
                    System.out.println("File: " + file.getName() + ", Size: " + file.length() + " bytes");
                } else if (file.isDirectory()) {
                    // Recursively call the method for directories
                    scanDirectory(file);
                }
            }
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Print out the file name and its size
                    System.out.println("File: " + file.getName() + ", Size: " + file.length() + " bytes");
                } else if (file.isDirectory()) {
                    // Recursively call the method for directories
                    scanDirectory(file);
                }
            }
        }
    }
}