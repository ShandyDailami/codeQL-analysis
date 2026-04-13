import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_02566_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.length() == 0) {
                    System.out.println("Warning: File '" + file.getName() + "' has a size of zero.");
                }
            }
        } else {
            System.out.println("Warning: No files found in the directory.");
        }
    }
}