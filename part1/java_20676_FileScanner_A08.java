import java.io.File;
import java.util.Scanner;

public class java_20676_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File directory = new File(dirPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        if (directory.listFiles() == null) {
            System.out.println("Directory is empty!");
            return;
        }

        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isHidden()) {
                System.out.println("Hidden file detected: " + file.getName());
            }

            if (file.length() == 0) {
                System.out.println("Zero-length file detected: " + file.getName());
            }

            long lastModified = file.lastModified();
            long currentTime = System.currentTimeMillis();

            if (lastModified > currentTime) {
                System.out.println("File was last modified after the current time: " + file.getName());
            }
        }
    }
}