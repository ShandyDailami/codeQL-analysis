import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22550_FileScanner_A01 {
    private static String[] permittedDirectories;
    private static String[] blockedDirectories;

    public static void main(String[] args) {
        loadPermittedDirectories();
        loadBlockedDirectories();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        if (isPermittedDirectory(directoryPath) && !isBlockedDirectory(directoryPath)) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }

    private static void loadPermittedDirectories() {
        try (Scanner scanner = new Scanner(new File("permitted_directories.txt"))) {
            permittedDirectories = scanner.nextLine().split("\\s+");
        } catch (FileNotFoundException e) {
            System.out.println("Error loading permitted directories: " + e.getMessage());
            System.exit(1);
        }
    }

    private static void loadBlockedDirectories() {
        try (Scanner scanner = new Scanner(new File("blocked_directories.txt"))) {
            blockedDirectories = scanner.nextLine().split("\\s+");
        } catch (FileNotFoundException e) {
            System.out.println("Error loading blocked directories: " + e.getMessage());
            System.exit(1);
        }
    }

    private static boolean isPermittedDirectory(String directoryPath) {
        for (String permittedDirectory : permittedDirectories) {
            File permittedFile = new File(directoryPath, permittedDirectory);
            if (permittedFile.exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isBlockedDirectory(String directoryPath) {
        for (String blockedDirectory : blockedDirectories) {
            File blockedFile = new File(directoryPath, blockedDirectory);
            if (blockedFile.exists()) {
                return true;
            }
        }
        return false;
    }
}