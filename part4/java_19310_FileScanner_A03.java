import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19310_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

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
                }
            } else {
                System.out.println("Given path is not a directory");
            }
        } else {
            System.out.println("Given directory does not exist");
        }
    }
}