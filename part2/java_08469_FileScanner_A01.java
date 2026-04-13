import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_08469_FileScanner_A01 {
    private static String targetDir;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory to start scanning:");
        targetDir = scanner.nextLine();

        File file = new File(targetDir);

        if (file.exists() && file.isDirectory()) {
            scanDir(file);
        } else {
            System.out.println("Invalid directory");
        }

        scanner.close();
    }

    private static void scanDir(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            Arrays.stream(files).forEach(SecureFileScanner::scanFile);
        }

        File[] subDirs = dir.listFiles(File::isDirectory);

        if (subDirs != null) {
            Arrays.stream(subDirs).forEach(SecureFileScanner::scanDir);
        }
    }

    private static void scanFile(File file) {
        if (file.getName().endsWith(".txt")) {
            // Perform security-sensitive operation related to A01_BrokenAccessControl
        }
    }
}