import java.io.File;
import java.util.Scanner;

public class java_18389_FileScanner_A03 {
    private static final String DIRECTORY = "C:/path/to/directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a file name to search:");
            String fileName = scanner.next();
            File file = new File(directory, fileName);
            if (file.exists()) {
                printFileDetails(file);
            } else {
                System.out.println("File not found.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getPath());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("File size: " + file.length() + " bytes");
        System.out.println("File type: " + (file.isFile() ? "File" : (file.isDirectory() ? "Directory" : "Unknown")));
    }
}