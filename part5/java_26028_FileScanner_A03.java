import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_26028_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.next();
        scanner.close();

        File directory = new File(path);
        if (directory.exists()) {
            String[] files = directory.list();
            if (files != null) {
                for (String file : files) {
                    System.out.println(file);
                }
            } else {
                System.out.println("No files found in the directory");
            }
        } else {
            System.out.println("Invalid directory path");
        }
    }
}