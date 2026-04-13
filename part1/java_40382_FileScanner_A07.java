import java.io.File;
import java.util.Scanner;

public class java_40382_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Directory exists and is a directory");
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();
                        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);

                        if (extension.equals("txt") || extension.equals("doc") || extension.equals("docx") || extension.equals("pdf") || extension.equals("xls") || extension.equals("xlsx")) {
                            System.out.println("File: " + fileName + " is a security-sensitive operation related to A07_AuthFailure");
                        }
                    }
                }
            } else {
                System.out.println("No files in the directory");
            }
        } else {
            System.out.println("Directory does not exist or is not a directory");
        }

        scanner.close();
    }
}