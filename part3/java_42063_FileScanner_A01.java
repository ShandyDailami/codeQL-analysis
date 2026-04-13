import java.io.File;
import java.util.Scanner;

public class java_42063_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (file.getName().endsWith(".txt")) {
                            printFileInfo(file);
                        }
                    } else if (file.isDirectory()) {
                        printDirectoryInfo(file);
                    }
                }
            } else {
                System.out.println("Directory not found.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static void printDirectoryInfo(File directory) {
        System.out.println("Directory: " + directory.getAbsolutePath());
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}