import java.io.File;
import java.util.Scanner;

public class java_03195_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("Invalid directory path");
        }
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }
}