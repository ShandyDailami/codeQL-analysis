import java.io.File;
import java.util.Scanner;

public class java_11825_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFileInfo(file);
                    } else if (file.isDirectory()) {
                        printDirectoryInfo(file);
                    }
                }
            } else {
                System.out.println("Directory does not exist or is not a directory.");
            }
        } else {
            System.out.println("Provided path does not exist or is not a directory.");
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("Last modified: " + file.lastModified());
    }

    private static void printDirectoryInfo(File file) {
        System.out.println("Directory: " + file.getName());
        System.out.println("Path: " + file.getPath());
        System.out.println("Absolute path: " + file.getAbsolutePath());
    }
}