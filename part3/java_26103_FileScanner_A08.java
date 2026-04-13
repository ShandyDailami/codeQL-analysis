import java.io.File;
import java.util.Scanner;

public class java_26103_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the directory:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            String[] files = dir.list();

            if (files != null) {
                for (String file : files) {
                    File fileObj = new File(dirPath + "/" + file);

                    if (fileObj.isFile() && fileObj.canRead()) {
                        System.out.println("File: " + fileObj.getName());
                    } else if (fileObj.isDirectory()) {
                        System.out.println("Directory: " + fileObj.getName());
                    }
                }
            } else {
                System.out.println("No files in the directory.");
            }
        } else {
            System.out.println("Invalid directory or not a directory.");
        }
    }
}