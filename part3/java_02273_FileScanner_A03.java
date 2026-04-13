import java.io.File;
import java.util.Scanner;

public class java_02273_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                String[] children = file.list();
                if (children != null) {
                    for (String child : children) {
                        File childFile = new File(file, child);
                        if (childFile.isFile()) {
                            System.out.println("File: " + childFile.getAbsolutePath());
                        } else if (childFile.isDirectory()) {
                            System.out.println("Directory: " + childFile.getAbsolutePath());
                        }
                    }
                } else {
                    System.out.println("No files found in the directory.");
                }
            } else {
                System.out.println("Not a directory: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("File or directory does not exist: " + path);
        }
    }
}