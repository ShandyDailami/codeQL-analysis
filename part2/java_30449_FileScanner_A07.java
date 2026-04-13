import java.io.File;
import java.util.Scanner;

public class java_30449_FileScanner_A07 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Reading files in directory: " + directoryPath);
            String[] files = directory.list();

            if (files != null) {
                for (String file : files) {
                    File fileObj = new File(directoryPath + "/" + file);

                    if (fileObj.isFile() && fileObj.canRead()) {
                        System.out.println("File: " + fileObj.getName());

                        Scanner fileScanner = new Scanner(fileObj);
                        while (fileScanner.hasNextLine()) {
                            System.out.println("Content: " + fileScanner.nextLine());
                        }
                        fileScanner.close();
                    }
                }
            } else {
                System.out.println("No files found in the directory.");
            }
        } else {
            System.out.println("The provided path is not a valid directory.");
        }
        scanner.close();
    }
}