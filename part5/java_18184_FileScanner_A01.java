import java.io.File;
import java.util.Scanner;

public class java_18184_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Scanning files in directory: " + directoryPath);

            String[] files = directory.list();

            if (files != null) {
                for (String file : files) {
                    File fileObj = new File(directoryPath + "/" + file);

                    if (fileObj.isFile() && fileObj.canRead()) {
                        System.out.println("Found file: " + fileObj.getName());
                    }
                }
            } else {
                System.out.println("No files in directory: " + directoryPath);
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }
    }
}