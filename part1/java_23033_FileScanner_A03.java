import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23033_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.isDirectory()) {
            printDirectoryContents(directory);
        } else {
            System.out.println("Not a directory!");
        }

        scanner.close();
    }

    private static void printDirectoryContents(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getAbsolutePath());
                    printDirectoryContents(file);
                }
            }
        }
    }
}