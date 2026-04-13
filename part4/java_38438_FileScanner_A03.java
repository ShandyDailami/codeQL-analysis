import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_38438_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the extension to search for:");
        String extension = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files == null) {
            System.out.println("No files found with the specified extension.");
            return;
        }

        Arrays.stream(files).forEach(file -> System.out.println(file.getPath()));
    }
}