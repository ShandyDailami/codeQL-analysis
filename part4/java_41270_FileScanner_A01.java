import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41270_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.next();

        File dir = new File(dirPath);

        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path");
            return;
        }

        System.out.println("Enter the file name to search:");
        String fileName = scanner.next();

        File file = new File(dir, fileName);

        if (!file.exists()) {
            System.out.println("File not found");
            return;
        }

        if (file.isDirectory()) {
            searchInDirectory(file, scanner);
        } else {
            System.out.println("File found: " + file.getAbsolutePath());
        }
    }

    private static void searchInDirectory(File dir, Scanner scanner) {
        File[] files = dir.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                searchInDirectory(file, scanner);
            } else {
                System.out.println("File found in subdirectory: " + file.getAbsolutePath());
            }
        }
    }
}