import java.io.File;
import java.util.Scanner;

public class java_18086_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

                if (txtFiles != null) {
                    for (File txtFile : txtFiles) {
                        System.out.println("Found .txt file: " + txtFile.getAbsolutePath());
                    }
                } else {
                    System.out.println("No .txt files found in the directory.");
                }
            } else {
                System.out.println("Given path is not a directory.");
            }
        } else {
            System.out.println("Given directory does not exist.");
        }

        scanner.close();
    }
}