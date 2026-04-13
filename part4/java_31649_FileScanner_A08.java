import java.io.File;
import java.util.Scanner;

public class java_31649_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.next();
        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("File Name: " + file.getName());
                        System.out.println("File Path: " + file.getAbsolutePath());
                        System.out.println("File Size: " + file.length() + " bytes");
                    }
                }
            } else {
                System.out.println("No files in directory!");
            }
        } else {
            System.out.println("Invalid directory!");
        }

        scanner.close();
    }
}