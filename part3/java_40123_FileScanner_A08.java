import java.io.File;
import java.util.Scanner;

public class java_40123_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isFileSafe(file)) {
                    System.out.println("Safe file: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                }
            }
        }
    }

    private static boolean isFileSafe(File file) {
        // Implement your own security checks here
        // For simplicity, let's assume all files are safe
        return true;
    }
}