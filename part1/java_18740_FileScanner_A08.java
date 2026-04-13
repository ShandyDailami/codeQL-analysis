import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_18740_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("Cannot list files in directory.");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
                printFileInfo(file);
            }
        }

        scanner.close();
    }

    private static void printFileInfo(File file) {
        System.out.println("--------------------------");
        System.out.println("File Name: " + file.getName());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Parent Path: " + file.getParent());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("Last Modified: " + file.lastModified());
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
    }
}