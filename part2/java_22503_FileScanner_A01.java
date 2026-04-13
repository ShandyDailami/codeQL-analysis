import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class java_22503_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File(".");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);
            printDirectoryContents(directory);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void printDirectoryContents(File directory) throws IOException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printDirectoryContents(file);
                } else {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        }
    }
}