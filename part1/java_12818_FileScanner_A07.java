import java.io.File;
import java.util.Scanner;

public class java_12818_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    long lastModified = file.lastModified();
                    long currentTime = System.currentTimeMillis();
                    long timeDiff = currentTime - lastModified;

                    // Check if file is older than 10 minutes
                    if (timeDiff < 10 * 60 * 1000) {
                        System.out.println("AuthFailure detected in file: " + file.getName());
                    }
                }
            }
        }
    }
}