import java.io.File;
import java.util.Scanner;

public class java_40452_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists()) {
            if (dir.isDirectory()) {
                File[] files = dir.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println("File: " + file.getName());
                        } else if (file.isDirectory()) {
                            System.out.println("Directory: " + file.getName());
                        }
                    }
                } else {
                    System.out.println("No files found in the directory");
                }
            } else {
                System.out.println("Not a directory");
            }
        } else {
            System.out.println("Directory not found");
        }

        scanner.close();
    }
}