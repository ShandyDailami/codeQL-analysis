import java.io.File;
import java.util.Scanner;

public class java_06229_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String path = scanner.nextLine();
        File directory = new File(path);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                System.out.println("Listing files in: " + directory.getAbsolutePath());
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            System.out.println(file.getName());
                        } else if (file.isDirectory()) {
                            System.out.println("Directory: " + file.getAbsolutePath());
                        }
                    }
                } else {
                    System.out.println("No files found in the directory.");
                }
            } else {
                System.out.println("Not a directory: " + directory.getAbsolutePath());
            }
        } else {
            System.out.println("Directory does not exist: " + directory.getAbsolutePath());
        }
        scanner.close();
    }
}