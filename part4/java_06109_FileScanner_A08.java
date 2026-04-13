import java.io.File;
import java.util.Scanner;

public class java_06109_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        if (directory.exists()) {
            File[] textFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (textFiles != null) {
                for (File textFile : textFiles) {
                    System.out.println("File: " + textFile.getName());
                    // TODO: Handle file operations
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}