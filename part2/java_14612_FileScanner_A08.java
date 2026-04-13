import java.io.File;
import java.util.Scanner;

public class java_14612_FileScanner_A08 {

    public static void main(String[] args) {

        // prompt user for directory path
        System.out.print("Enter the directory path: ");
        Scanner scanner = new Scanner(System.in);
        String directoryPath = scanner.nextLine();

        // create a new File object for the directory
        File directory = new File(directoryPath);

        // scan all files in the directory
        File[] files = directory.listFiles();

        // print out all file names
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
            }
        }
    }
}