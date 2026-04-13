import java.io.File;
import java.util.Scanner;

public class java_29074_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.next();

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                String[] files = file.list();
                if (files != null) {
                    for (String fileName : files) {
                        File filePath = new File(file.getPath(), fileName);
                        if (filePath.isFile()) {
                            System.out.println("File: " + filePath.getAbsolutePath());
                        } else if (filePath.isDirectory()) {
                            System.out.println("Directory: " + filePath.getAbsolutePath());
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