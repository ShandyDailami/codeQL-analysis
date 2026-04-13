import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_24546_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Directory contents:");
            printDirectoryContents(directory, 0);
        } else {
            System.out.println("Invalid directory path");
        }
    }

    private static void printDirectoryContents(File directory, int indentationLevel) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indentationLevel(indentationLevel) + "Directory: " + file.getName());
                    printDirectoryContents(file, indentationLevel + 1);
                } else {
                    System.out.println(indentationLevel(indentationLevel) + "File: " + file.getName());
                }
            }
        }
    }

    private static String indentationLevel(int level) {
        return Arrays.stream(new String[level].iterator()).reduce("", String::concat);
    }
}