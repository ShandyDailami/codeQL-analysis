import java.io.File;
import java.util.Scanner;

public class java_20376_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Searching for .txt files...");
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    if (txtFile.canRead()) {
                        System.out.println("Found readable file: " + txtFile.getAbsolutePath());
                    } else {
                        System.out.println("File " + txtFile.getAbsolutePath() + " is not readable.");
                    }
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("The provided path is not a valid directory.");
        }

        scanner.close();
    }
}