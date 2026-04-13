import java.io.File;
import java.util.Scanner;

public class java_27520_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File Name: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}