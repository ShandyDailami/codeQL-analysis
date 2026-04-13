import java.io.File;
import java.util.Scanner;

public class java_36730_FileScanner_A01 {
    public static void main(String[] args) {
        System.out.println("Enter the directory path:");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getAbsolutePath());
                        readFile(file);
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }

    private static void readFile(File file) {
        if (file.canRead()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    System.out.println("Content of file: " + scanner.nextLine());
                }
            }
        } else {
            System.out.println("File cannot be read.");
        }
    }
}