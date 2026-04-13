import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_41241_FileScanner_A08 {

    private static final String SECURITY_WARNING = "Warning: ";
    private static final String INTEGRITY_CHECK_FAILURE = "Integrity Check Failed";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.next();
        scanner.close();

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        if (directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        }).length == 0) {
            System.out.println("No Java files in the directory");
            return;
        }

        File[] javaFiles = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });

        for (File file : javaFiles) {
            if (!checkFileIntegrity(file)) {
                System.out.println(SECURITY_WARNING + "Integrity check failed for file: " + file.getAbsolutePath());
            } else {
                System.out.println("Integrity check passed for file: " + file.getAbsolutePath());
            }
        }
    }

    private static boolean checkFileIntegrity(File file) {
        // Simplified integrity check: Check file size
        return file.length() > 0;
    }
}