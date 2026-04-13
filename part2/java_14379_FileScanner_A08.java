import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14379_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path, please try again.");
            return;
        }

        System.out.println("Enter the file path:");
        String filePath = scanner.nextLine();
        File file = new File(filePath);

        if (!file.exists() || file.isDirectory()) {
            System.out.println("Invalid file path, please try again.");
            return;
        }

        long fileSize = file.length();
        long directorySize = getDirectorySize(directory);

        if (fileSize != directorySize) {
            System.out.println("File integrity failure!");
        } else {
            System.out.println("File integrity check passed!");
        }
    }

    private static long getDirectorySize(File directory) {
        long size = 0;
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    size += file.length();
                } else if (file.isDirectory()) {
                    size += getDirectorySize(file);
                }
            }
        }
        return size;
    }
}