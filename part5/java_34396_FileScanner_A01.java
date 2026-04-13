import java.io.File;
import java.util.Scanner;

public class java_34396_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();

            if (files != null) {
                for (String fileName : files) {
                    File file = new File(directoryPath + "/" + fileName);

                    if (file.isFile()) {
                        System.out.println("File name: " + file.getName());
                        System.out.println("File path: " + file.getPath());
                        System.out.println("Absolute path: " + file.getAbsolutePath());
                        System.out.println("File size: " + file.length() + " bytes");
                        System.out.println("----------------------");
                    }
                }
            } else {
                System.out.println("No files in the directory");
            }
        } else {
            System.out.println("Invalid directory path");
        }
    }
}