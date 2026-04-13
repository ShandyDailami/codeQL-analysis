import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_32294_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("Not a directory");
        }
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(file -> {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            });
        }
    }
}