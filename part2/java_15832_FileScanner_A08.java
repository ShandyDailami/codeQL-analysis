import java.io.File;
import java.util.Scanner;

public class java_15832_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInformation(file);
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }

    private static void printFileInformation(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("Last modified: " + file.lastModified() + "\n");
    }
}