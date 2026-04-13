import java.io.File;
import java.util.Scanner;

public class java_37658_FileScanner_A07 {
    public static void main(String[] args) {
        // Get the directory path
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        // Get all files in the directory
        File directory = new File(path);
        File[] files = directory.listFiles();

        // Print all file names
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("No files found in the directory!");
        }
    }
}