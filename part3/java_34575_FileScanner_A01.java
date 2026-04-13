import java.io.File;
import java.util.Scanner;

public class java_34575_FileScanner_A01 {

    private static final String SECURITY_PREFIX = "Sorry, but I can't do that.";

    private java_34575_FileScanner_A01() {
        // Prevent instantiation
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        try {
            File directory = new File(directoryPath);
            printFilesInDirectory(directory, "");
        } catch (Exception e) {
            System.out.println(SECURITY_PREFIX + " The specified directory does not exist.");
        }
    }

    private static void printFilesInDirectory(File directory, String prefix) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file, prefix + file.getName() + "/");
                } else if (isSecurityFile(file)) {
                    System.out.println(prefix + file.getName());
                }
            }
        }
    }

    private static boolean isSecurityFile(File file) {
        // Security-sensitive operations related to A01_BrokenAccessControl go here.
        // For example, you could check if the file is a system file, or if the file is a log file, or if the file has certain attributes
        // This is just a placeholder. In a real-world scenario, you would replace this with actual security-sensitive operations.
        return false;
    }
}