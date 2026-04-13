import java.io.File;
import java.util.Scanner;

public class java_39442_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Enter the pattern for file names:");
            String pattern = scanner.nextLine();

            File[] matchingFiles = directory.listFiles((dir, name) -> name.matches(pattern));

            if (matchingFiles != null) {
                for (File file : matchingFiles) {
                    if (file.isFile()) {
                        System.out.println(file.getName());
                    }
                }
            } else {
                System.out.println("No files found with pattern: " + pattern);
            }
        } else {
            System.out.println(dirPath + " is not a valid directory.");
        }

        scanner.close();
    }
}