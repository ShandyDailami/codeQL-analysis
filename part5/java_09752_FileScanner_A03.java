import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09752_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        try {
            File file = new File(directoryPath);
            if (file.exists()) {
                if (file.isDirectory()) {
                    printFilesInDirectory(file);
                } else {
                    System.out.println("The provided path is not a directory.");
                }
            } else {
                System.out.println("The provided path does not exist.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void printFilesInDirectory(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileInfo(file);
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        } else {
            System.out.println("No files in the directory.");
        }
    }

    private static void printFileInfo(File file) throws FileNotFoundException {
        System.out.println("File Name: " + file.getName());
        System.out.println("File Path: " + file.getAbsolutePath());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("---------------------");
    }
}