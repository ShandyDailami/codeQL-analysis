import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32657_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        scanFilesInDirectory(directory);
    }

    private static void scanFilesInDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileName(file);
                } else if (file.isDirectory()) {
                    scanFilesInDirectory(file);
                }
            }
        }
    }

    private static void printFileName(File file) {
        System.out.println(file.getName());
    }
}