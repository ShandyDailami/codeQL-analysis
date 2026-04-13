import java.io.File;
import java.util.Scanner;

public class java_10529_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);
        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Searching for files in directory: " + directory.getAbsolutePath());
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            System.out.println("File found: " + file.getAbsolutePath());
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Directory found: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory or non-existing directory.");
        }
    }
}