import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_29453_FileScanner_A03 {
    public static void main(String[] args) {
        String currentDir = new File(".").getAbsolutePath();
        System.out.println("Current directory: " + currentDir);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path (leave blank for current):");
        String dirPath = scanner.nextLine();
        if (dirPath.isEmpty()) {
            dirPath = currentDir;
        }

        File directory = new File(dirPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("No files in directory!");
            return;
        }

        System.out.println("Files in directory: " + Arrays.toString(files));
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
            }
        }

        scanner.close();
    }
}