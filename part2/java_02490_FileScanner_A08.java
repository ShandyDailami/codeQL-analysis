import java.io.File;
import java.util.Scanner;

public class java_02490_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}