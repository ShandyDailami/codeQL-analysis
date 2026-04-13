import java.io.File;
import java.util.Scanner;

public class java_12594_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);
        printFiles(directory);
    }

    private static void printFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getPath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getPath());
                    printFiles(file);
                }
            }
        }
    }
}