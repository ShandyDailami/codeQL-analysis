import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28303_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            FileFilter filter = new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.getName().endsWith("." + fileExtension);
                }
            };

            printFilesInDirectory(directory, filter);
        } else {
            System.out.println("The directory does not exist.");
        }
    }

    private static void printFilesInDirectory(File directory, FileFilter filter) {
        File[] files = directory.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file, filter);
                }
            }
        }
    }
}