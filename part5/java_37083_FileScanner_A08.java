import java.io.File;
import java.util.Scanner;

public class java_37083_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.isDirectory()) {
            String[] files = directory.list();
            if (files != null) {
                for (String file : files) {
                    File fileObj = new File(directory.getPath() + "/" + file);
                    if (fileObj.isFile()) {
                        System.out.println(fileObj.getName());
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path or directory does not exist.");
        }

        scanner.close();
    }
}