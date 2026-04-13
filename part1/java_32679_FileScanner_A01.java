import java.io.File;
import java.util.Scanner;

public class java_32679_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            exploreDirectory(directory);
        } else {
            System.out.println("Directory not found");
        }

        scanner.close();
    }

    private static void exploreDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    exploreDirectory(file);
                } else {
                    // File is a regular file, process it here
                    System.out.println("File: " + file.getPath());
                }
            }
        }
    }
}