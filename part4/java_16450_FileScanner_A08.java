import java.io.File;
import java.util.Scanner;

public class java_16450_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        File dir = new File(path);

        printFilesAndDirectories(dir);
    }

    private static void printFilesAndDirectories(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printFilesAndDirectories(file);
                }
            }
        }
    }
}