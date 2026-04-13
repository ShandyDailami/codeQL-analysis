import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40645_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        File directory = new File(path);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files or directories found in the given path.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}