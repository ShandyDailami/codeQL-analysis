import java.io.File;
import java.util.Scanner;

public class java_15232_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Searching for .txt files in directory: " + directoryPath);
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    System.out.println("Found .txt file: " + txtFile.getName());
                }
            } else {
                System.out.println("No .txt files found in directory");
            }
        } else {
            System.out.println("Invalid directory");
        }
    }
}