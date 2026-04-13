import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_41480_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(dirPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            Arrays.stream(files).forEach(file -> System.out.println("File: " + file.getName()));
        } else {
            System.out.println("No files found with the specified extension.");
        }

        scanner.close();
    }
}