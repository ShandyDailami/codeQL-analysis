import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16800_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file extension: ");
        String fileExtension = scanner.next();

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files == null) {
            System.out.println("No files found with extension: " + fileExtension);
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            }
        }

        scanner.close();
    }
}