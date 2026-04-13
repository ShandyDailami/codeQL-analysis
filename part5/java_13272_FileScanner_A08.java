import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_13272_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    checkFileIntegrity(file);
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    checkDirectory(file);
                }
            }
        }

        scanner.close();
    }

    private static void checkFileIntegrity(File file) {
        // Simulate security-sensitive operation related to integrity
        // Here, we assume that a file is corrupted if its hashcode is not the same as its content's hashcode
        try {
            FileChecker checker = new FileChecker(file);
            if (checker.getFileHashCode() != checker.getFileContentHashCode()) {
                System.out.println("Corruption detected in file: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("An error occurred while checking the integrity of file: " + file.getAbsolutePath());
        }
    }

    private static void checkDirectory(File dir) {
        // Simulate security-sensitive operation related to integrity
        // Here, we assume that a directory is corrupted if its hashcode is not the same as its content's hashcode
        try {
            FileChecker checker = new FileChecker(dir);
            if (checker.getDirHashCode() != checker.getDirContentHashCode()) {
                System.out.println("Corruption detected in directory: " + dir.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("An error occurred while checking the integrity of directory: " + dir.getAbsolutePath());
        }
    }
}