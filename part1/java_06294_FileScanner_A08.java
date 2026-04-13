import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_06294_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.next();
        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist.");
            return;
        }
        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files in directory.");
            return;
        }
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            }
        }
    }
}