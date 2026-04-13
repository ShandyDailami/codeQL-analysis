import java.io.File;
import java.util.Scanner;

public class java_06634_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println("File: " + file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }
}