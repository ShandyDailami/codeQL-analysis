import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_31304_FileScanner_A03 {
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

            if (txtFiles != null && txtFiles.length > 0) {
                Arrays.stream(txtFiles).forEach(file -> printFileDetails(file));
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }

    private static void printFileDetails(File file) {
        if (file.exists() && file.isFile()) {
            System.out.println("File Name: " + file.getName());
            System.out.println("File Path: " + file.getPath());
            System.out.println("File Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Size: " + file.length() + " bytes");
            System.out.println("------------------------");
        }
    }
}