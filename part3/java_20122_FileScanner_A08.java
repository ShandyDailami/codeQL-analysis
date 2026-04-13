import java.io.File;
import java.util.Scanner;

public class java_20122_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        try {
            checkIntegrity(directory);
            System.out.println("All files and directories in the directory are valid.");
        } catch (Exception e) {
            System.out.println("Error checking integrity: " + e.getMessage());
        }
    }

    private static void checkIntegrity(File directory) throws Exception {
        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                checkIntegrity(file);
            } else {
                checkFileIntegrity(file);
            }
        }
    }

    private static void checkFileIntegrity(File file) throws Exception {
        if (file.delete()) {
            System.out.println("Deleted file: " + file.getAbsolutePath());
        } else {
            throw new Exception("Failed to delete file: " + file.getAbsolutePath());
        }
    }
}