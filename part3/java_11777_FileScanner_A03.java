import java.io.File;
import java.util.Scanner;

public class java_11777_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().endsWith(".java")) {
                        System.out.println("Found a Java file: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    System.out.println("Found a directory: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}