import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_17696_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        File directory = new File(dirPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && isFileAccessible(file)) {
                        System.out.println("File: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }

    private static boolean isFileAccessible(File file) {
        try {
            return file.setReadable(true, false);
        } catch (SecurityException e) {
            System.out.println("Access denied for " + file.getAbsolutePath());
            return false;
        }
    }
}