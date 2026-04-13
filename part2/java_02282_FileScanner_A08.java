import java.io.File;
import java.util.Scanner;

public class java_02282_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (dir.exists()) {
            if (dir.isDirectory()) {
                printFilesInDirectory(dir);
            } else {
                System.out.println("The provided path is not a directory.");
            }
        } else {
            System.out.println("The provided directory does not exist.");
        }
    }

    private static void printFilesInDirectory(File dir) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else {
                    printFilesInDirectory(file);
                }
            }
        }
    }
}