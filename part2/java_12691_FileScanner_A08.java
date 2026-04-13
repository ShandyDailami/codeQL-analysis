import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_12691_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else {
                    System.out.println("Directory: " + file.getName());
                }
            }
        } else {
            System.out.println("No files or directories found in the specified directory.");
        }

        scanner.close();
    }
}