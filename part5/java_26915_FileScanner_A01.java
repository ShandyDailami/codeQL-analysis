import java.io.File;
import java.util.Scanner;

public class java_26915_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        System.out.println("Size: " + file.length() + " bytes");
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                        getDirectorySize(file);
                    }
                }
            }
        } else {
            System.out.println("The provided directory path does not exist.");
        }

        scanner.close();
    }

    private static void getDirectorySize(File directory) {
        long length = 0;
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    length += file.length();
                } else if (file.isDirectory()) {
                    length += getDirectorySize(file);
                }
            }
        }

        System.out.println("Size: " + length + " bytes");
    }
}