import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_09030_FileScanner_A08 {
    private static final Set<String> FILE_EXTENSIONS = Set.of(".txt", ".jpg", ".jpeg", ".png", ".docx", ".csv", ".xlsx", ".xls", ".avi", ".mp3", ".mp4", ".mkv");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }
        try {
            Set<File> files = new HashSet<>(Listing.listFiles(directory, FILE_EXTENSIONS, true));
            System.out.println("Total files: " + files.size());
            for (File file : files) {
                long length = file.length();
                if (length < 1000) {
                    System.out.println("File: " + file.getName() + ", Size: " + length + " bytes");
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading directory: " + e.getMessage());
        }
    }
}