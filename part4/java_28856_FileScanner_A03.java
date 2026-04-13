import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_28856_FileScanner_A03 {

    private static final Set<String> ALLOWED_EXTENSIONS = Set.of(".txt", ".jpg", ".png", ".jpeg");

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the directory path: ");
            String dirPath = scanner.nextLine();
            System.out.print("Enter the file extension to scan (e.g., .txt): ");
            String fileExtension = scanner.nextLine();
            processDirectory(new File(dirPath), fileExtension);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static void processDirectory(File directory, String fileExtension) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    processDirectory(file, fileExtension);
                } else if (isFileAllowed(file) && file.getName().endsWith(fileExtension)) {
                    System.out.println("File found: " + file.getPath());
                    // Add code here to handle the file (e.g., reading it, processing it, etc.)
                }
            }
        }
    }

    private static boolean isFileAllowed(File file) {
        String name = file.getName();
        int lastDotIndex = name.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return false;
        }
        String extension = name.substring(lastDotIndex + 1);
        return ALLOWED_EXTENSIONS.contains(extension);
    }
}