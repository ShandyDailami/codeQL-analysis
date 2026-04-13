import java.io.File;
import java.util.Scanner;

public class java_01140_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            listFiles(directory);
        } else {
            System.out.println("Invalid directory path");
        }

        scanner.close();
    }

    private static void listFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFilePath(file);
                } else if (file.isDirectory()) {
                    listFiles(file);
                }
            }
        }
    }

    private static void printFilePath(File file) {
        if (file.canRead()) {
            System.out.println(file.getAbsolutePath());
        } else {
            System.out.println("Unable to read file: " + file.getAbsolutePath());
        }
    }
}