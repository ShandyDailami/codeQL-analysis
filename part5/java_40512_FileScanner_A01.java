import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40512_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        printFilesAndDirectories(directory, "");
    }

    private static void printFilesAndDirectories(File directory, String indentation) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indentation + "Directory: " + file.getName());
                    printFilesAndDirectories(file, indentation + "  ");
                } else {
                    System.out.println(indentation + "File: " + file.getName());
                }
            }
        }
    }
}