import java.io.File;
import java.util.Scanner;

public class java_15213_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                }
           
                if (file.isDirectory()) {
                    printDirectoryInfo(file);
                }
            }
        }

        scanner.close();
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Last modified: " + file.lastModified());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("------------------------");
    }

    private static void printDirectoryInfo(File directory) {
        System.out.println("Directory: " + directory.getName());
        System.out.println("Path: " + directory.getPath());
        System.out.println("Absolute path: " + directory.getAbsolutePath());
        System.out.println("------------------------");
    }
}