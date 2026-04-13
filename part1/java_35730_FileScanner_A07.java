import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_35730_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();

        try {
            File dir = new File(dirPath);
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        FileScanner fileScanner = new FileScanner(file);
                        fileScanner.scan();
                    }
                }
            } else {
                System.out.println("Directory does not exist or no read permissions.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while scanning the files.");
        } finally {
            scanner.close();
        }
    }
}