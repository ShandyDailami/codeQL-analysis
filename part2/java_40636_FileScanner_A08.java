import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40636_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            listFiles(directory);
        } else {
            System.out.println("Invalid directory path");
        }

        scanner.close();
    }

    private static void listFiles(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        String filePath = file.getCanonicalPath();
                        String fileName = file.getName();
                        File newFile = new File(filePath);

                        if (newFile.canExecute()) {
                            System.out.println("File: " + fileName + " has execute permissions");
                        } else {
                            System.out.println("File: " + fileName + " does not have execute permissions");
                        }
                    } catch (Exception e) {
                        System.out.println("Error reading file permissions: " + fileName);
                    }
                }
            }
        }
    }
}