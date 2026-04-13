import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00799_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // if no files found, print message and exit
        if (files == null) {
            System.out.println("No files found in the specified directory.");
            return;
        }

        // print file names
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        scanner.close();
    }
}