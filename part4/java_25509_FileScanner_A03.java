import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_25509_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

                        if (Arrays.asList("jpg", "jpeg", "png", "gif", "svg", "bmp").contains(extension)) {
                            System.out.println("Found image file: " + file.getAbsolutePath());
                        } else {
                            System.out.println("Found non-image file: " + file.getAbsolutePath());
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Found directory: " + file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files found in directory: " + dirPath);
            }
        } else {
            System.out.println("Invalid directory path: " + dirPath);
        }

        scanner.close();
    }
}