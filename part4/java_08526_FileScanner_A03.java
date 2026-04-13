import java.io.File;
import java.util.Scanner;

public class java_08526_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            printDirectoryContents(directory);
        } else {
            System.out.println("The path does not exist.");
        }

        scanner.close();
    }

    private static void printDirectoryContents(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printDirectoryContents(file);
                }
            }
        }
    }
}