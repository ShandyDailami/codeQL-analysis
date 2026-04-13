import java.io.File;
import java.util.Scanner;

public class java_21952_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = input.nextLine();

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            String[] fileList = directory.list();
            for (String fileName : fileList) {
                File file = new File(directoryPath + "/" + fileName);
                if (file.isFile()) {
                    printFileInfo(file);
                } else {
                    System.out.println("Directory: " + fileName);
                }
            }
        } else {
            System.out.println("Not a valid directory.");
        }
    }

    private static void printFileInfo(File file) {
        System.out.println("File: " + file.getName());
        System.out.println("Path: " + file.getAbsolutePath());
        System.out.println("Absolute path: " + file.getPath());
        System.out.println("Last modified: " + file.lastModified());
        System.out.println("Size: " + file.length() + " bytes");
    }
}