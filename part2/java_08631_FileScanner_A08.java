import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08631_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = input.next();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] insecureFiles = dir.listFiles(file -> {
                // Only files that are not marked as insecure
                return file.canRead() && !isFileInsecure(file);
            });

            if (insecureFiles != null) {
                for (File file : insecureFiles) {
                    System.out.println("Insecure file: " + file.getPath());
                }
            } else {
                System.out.println("No insecure files found.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        input.close();
    }

    // This method should be replaced with a more secure method to check a file's integrity
    private static boolean isFileInsecure(File file) {
        // Placeholder for actual security check. This method should be replaced with actual security check.
        // For example, a file could be checked for malicious code, or the file's timestamp could be checked.
        return false;
    }
}