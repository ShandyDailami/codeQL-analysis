import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_41075_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (directory.exists()) {
            File[] hiddenFiles = directory.listFiles(file -> file.isHidden());

            if (hiddenFiles != null) {
                for (File file : hiddenFiles) {
                    printHiddenFileInfo(file);
                }
            } else {
                System.out.println("No hidden files found in the directory.");
            }
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }

    private static void printHiddenFileInfo(File file) {
        if (file.isFile()) {
            System.out.println("File: " + file.getName());
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Size: " + file.length() + " bytes");
            System.out.println("Last modified: " + file.lastModified());
            System.out.println();
        }
    }
}