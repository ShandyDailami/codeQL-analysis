import java.io.File;
import java.util.Scanner;

public class java_17268_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    System.out.println("Found txt file: " + txtFile.getName());
                }
            } else {
                System.out.println("No txt files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }
    }
}