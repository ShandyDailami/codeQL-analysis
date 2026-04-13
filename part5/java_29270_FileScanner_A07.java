import java.io.File;
import java.util.Scanner;

public class java_29270_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Enter the file extension to search:");
            String extension = scanner.nextLine();

            System.out.println("Searching for files with extension: " + extension);

            File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(extension));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    if (file.isFile()) {
                        System.out.println("Found file: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found with extension: " + extension);
            }
        } else {
            System.out.println("Invalid directory or it's not a directory!");
        }
    }
}