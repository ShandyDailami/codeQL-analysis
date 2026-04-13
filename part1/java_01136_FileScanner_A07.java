import java.io.File;
import java.util.Scanner;

public class java_01136_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        long lastModified = file.lastModified();
                        if (lastModified < 1000000000L) {
                            System.out.println("File: " + file.getName());
                            System.out.println("Last modified: " + lastModified);
                        }
                    } else if (file.isDirectory()) {
                        long lastModified = file.lastModified();
                        System.out.println("Directory: " + file.getName());
                        System.out.println("Last modified: " + lastModified);
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}