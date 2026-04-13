import java.io.File;
import java.util.Scanner;

public class java_17275_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        // Break into directory for security-sensitive operation
        if (!directoryPath.endsWith("/") || !directoryPath.endsWith("\\")) {
            directoryPath += "/";
        }

        File file = new File(directoryPath);
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile() && f.getName().endsWith(".txt")) {
                    System.out.println(f.getName());
                }
            }
        } else {
            System.out.println("Error reading directory: " + directoryPath);
        }

        scanner.close();
    }
}