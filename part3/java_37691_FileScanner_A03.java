import java.io.File;
import java.util.Scanner;

public class java_37691_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File directory = new File(path);

        if (directory.isDirectory()) {
            String[] files = directory.list();
            if (files != null) {
                for (String file : files) {
                    File fileObject = new File(directory.getPath() + "/" + file);
                    if (fileObject.isFile()) {
                        System.out.println("File found: " + fileObject.getPath());
                    } else if (fileObject.isDirectory()) {
                        System.out.println("Directory found: " + fileObject.getPath());
                    }
                }
            } else {
                System.out.println("No files found in directory: " + directory.getPath());
            }
        } else {
            System.out.println("Provided path is not a directory.");
        }
    }
}