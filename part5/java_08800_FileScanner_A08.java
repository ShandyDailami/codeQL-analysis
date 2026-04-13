import java.io.File;
import java.util.Scanner;

public class java_08800_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (txtFiles != null) {
            for (File file : txtFiles) {
                System.out.println("Found .txt file: " + file.getName());
            }
        } else {
            System.out.println("No .txt files found in the directory.");
        }

        scanner.close();
    }
}