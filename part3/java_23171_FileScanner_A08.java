import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23171_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter directory path:");
            String dirPath = scanner.next();

            File dir = new File(dirPath);
            if (!dir.exists()) {
                System.out.println("Directory does not exist!");
                return;
            }

            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + file.getName());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}