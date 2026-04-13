import java.io.File;
import java.util.Scanner;

public class java_01419_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Directory: " + directory.getAbsolutePath());
            String[] files = directory.list();

            if (files != null) {
                for (String file : files) {
                    File fileObj = new File(directoryPath + "/" + file);

                    if (fileObj.isFile() && fileObj.canRead()) {
                        System.out.println("File: " + fileObj.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("No files in directory");
            }
        } else {
            System.out.println("Invalid directory path");
        }

        scanner.close();
    }
}