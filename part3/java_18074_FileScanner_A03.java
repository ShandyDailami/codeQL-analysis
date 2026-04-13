import java.io.File;
import java.util.Scanner;

public class java_18074_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);
        if (dir.exists()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in the directory!");
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}