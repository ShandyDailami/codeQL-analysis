import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25456_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Scanning files in directory: " + directoryPath);

            File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("Found file: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files found with extension: " + fileExtension);
            }
        } else {
            System.out.println("Invalid directory path or it's not a directory.");
        }
    }
}