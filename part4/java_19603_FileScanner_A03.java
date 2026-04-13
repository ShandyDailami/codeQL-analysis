import java.io.File;
import java.util.Scanner;

public class java_19603_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            listFilesAndDirectories(dir);
        } else {
            System.out.println("The path is not a directory.");
        }

        scanner.close();
    }

    private static void listFilesAndDirectories(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    listFilesAndDirectories(file);
                }
            }
        }
    }
}