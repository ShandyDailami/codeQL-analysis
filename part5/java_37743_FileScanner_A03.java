import java.io.File;
import java.util.Scanner;

public class java_37743_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        System.out.println("Enter file extension (e.g., '.txt'):");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with the specified extension.");
        }

        scanner.close();
    }
}