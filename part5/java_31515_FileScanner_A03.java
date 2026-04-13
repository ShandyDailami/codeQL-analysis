import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class java_31515_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);
        if (!directory.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (txtFiles == null) {
            System.out.println("No .txt files found in the directory.");
            return;
        }

        for (File file : txtFiles) {
            System.out.println("Found .txt file: " + file.getName());
        }

        scanner.close();
    }
}