import java.io.File;
import java.util.Scanner;

public class java_27535_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            System.exit(0);
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files found in the directory");
            System.exit(0);
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File found: " + file.getAbsolutePath());
            }
        }

        scanner.close();
    }
}