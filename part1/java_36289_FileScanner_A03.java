import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36289_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = input.nextLine();
        File directory = new File(path);

        if (directory.exists()) {
            printFilesInDirectory(directory);
        } else {
            System.out.println("Directory not found!");
        }
    }

    private static void printFilesInDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    printFilesInDirectory(file);
                }
            }
        }
    }
}