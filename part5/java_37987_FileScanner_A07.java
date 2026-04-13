import java.io.File;
import java.util.Scanner;

public class java_37987_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && (file.getName().endsWith(".txt") || file.getName().endsWith(".log"))) {
                        System.out.println("File name: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files in the directory");
            }
        } else {
            System.out.println("Invalid directory");
        }
    }
}