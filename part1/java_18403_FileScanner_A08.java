import java.io.File;
import java.util.Scanner;

public class java_18403_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();

        System.out.println("Enter the extension you are looking for (e.g., .txt):");
        String extension = scanner.next();

        scanner.close();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("The directory does not exist.");
        }
    }
}