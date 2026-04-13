import java.io.File;
import java.util.Scanner;

public class java_25577_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Searching for .txt files in " + directory.getAbsolutePath());

            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    System.out.println("Found .txt file: " + txtFile.getAbsolutePath());
                }
            } else {
                System.out.println("No .txt files found in " + directory.getAbsolutePath());
            }
        } else {
            System.out.println("Invalid directory path or directory does not exist");
        }

        scanner.close();
    }
}