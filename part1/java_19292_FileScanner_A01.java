import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_19292_FileScanner_A01 {
    public static void main(String[] args) {
        // Initialize scanner
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        try {
            // Use FileScanner to scan directory
            File dir = new File(dirPath);
            if (dir.exists()) {
                File[] files = dir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            printFileInfo(file);
                        } else if (file.isDirectory()) {
                            System.out.println("Directory: " + file.getAbsolutePath());
                            File[] subFiles = file.listFiles();
                            if (subFiles != null) {
                                for (File subFile : subFiles) {
                                    if (subFile.isFile()) {
                                        printFileInfo(subFile);
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("Directory does not exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Close scanner
        scanner.close();
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Path: " + file.getPath());
        System.out.println("Last modified: " + file.lastModified());
        System.out.println("-----------------------");
    }
}