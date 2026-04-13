import java.io.File;
import java.util.Scanner;

public class java_13184_FileScanner_A01 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                int totalFiles = 0;
                for (File file : files) {
                    if (file.isFile()) {
                        totalFiles++;
                        System.out.println("File: " + file.getName());
                    }
                }
                System.out.println("Total files: " + totalFiles);
            } else {
                System.out.println("No files in the directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}