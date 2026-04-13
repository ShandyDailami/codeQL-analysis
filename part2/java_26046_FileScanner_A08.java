import java.io.File;
import java.util.Scanner;

public class java_26046_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension (for example, '.txt'):");
        String extension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files found in the specified directory.");
        }
    }
}