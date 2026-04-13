import java.io.File;
import java.util.Scanner;

public class java_34007_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] files = directory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            String fileName = file.getName();
                            String extension = fileName.substring(fileName.lastIndexOf("."));
                            if (extension.equalsIgnoreCase(".txt") || extension.equalsIgnoreCase(".doc") || extension.equalsIgnoreCase(".docx") || extension.equalsIgnoreCase(".pdf") || extension.equalsIgnoreCase(".xls") || extension.equalsIgnoreCase(".xlsx")) {
                                System.out.println("File Name: " + fileName);
                            }
                        }
                    }
                }
            } else {
                System.out.println("Given path is not a directory.");
            }
        } else {
            System.out.println("Given directory does not exist.");
        }
    }
}