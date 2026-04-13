import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41319_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the directory you want to scan:");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);
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
            System.out.println("No files or directories found in the specified path.");
        }
    }
}