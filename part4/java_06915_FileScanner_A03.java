import java.io.File;
import java.util.Scanner;

public class java_06915_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (files != null) {
            for (File file : files) {
                System.out.println("File found: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("No files found with the given extension in the directory.");
        }

        scanner.close();
    }
}