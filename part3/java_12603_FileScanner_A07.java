import java.io.File;
import java.util.Scanner;

public class java_12603_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] listOfFiles = directory.listFiles();
            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        String filePath = file.getAbsolutePath();
                        long fileSize = file.length();

                        if (fileSize > 10000000) {  // 1MB
                            System.out.println("File: " + filePath + ", Size: " + fileSize + " bytes");
                        }
                    } else if (file.isDirectory()) {
                        System.out.println("Directory: " + filePath);
                        listFiles(file);
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("The specified file does not exist or it is not a directory.");
        }

        scanner.close();
    }

    private static void listFiles(File file) {
        if (file.isDirectory()) {
            File[] listOfFiles = file.listFiles();
            if (listOfFiles != null) {
                for (File childFile : listOfFiles) {
                    if (childFile.isFile()) {
                        System.out.println("Directory: " + childFile.getAbsolutePath());
                    } else if (childFile.isDirectory()) {
                        listFiles(childFile);
                    }
                }
            }
        }
    }
}