import java.io.File;
import java.util.Scanner;

public class java_24951_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            printFiles(directory);
        } else {
            System.out.println("Invalid directory path");
        }
    }

    private static void printFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    printFiles(file);
                }
            }
        }
    }
}