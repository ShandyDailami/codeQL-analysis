import java.io.File;
import java.util.Scanner;

public class java_33794_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            readFilesFromDirectory(directory);
        } else {
            System.out.println("Invalid directory path or no such directory exists.");
        }

        scanner.close();
    }

    private static void readFilesFromDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    readFilesFromDirectory(file);
                }
            }
        }
    }
}