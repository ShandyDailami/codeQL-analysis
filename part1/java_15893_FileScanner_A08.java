import java.io.File;
import java.util.Scanner;

public class java_15893_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    System.out.println("File: " + f.getName());
                } else if (f.isDirectory()) {
                    System.out.println("Directory: " + f.getName());
                }
            }
        } else {
            System.out.println("No files found in the directory");
        }
    }
}