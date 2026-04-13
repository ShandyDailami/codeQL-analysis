import java.io.File;
import java.util.Scanner;

public class java_23098_FileScanner_A03 {
    public static void main(String[] args) {
        // create a scanner to read input from the command line
        Scanner scanner = new Scanner(System.in);

        // prompt the user to enter a directory
        System.out.println("Enter a directory:");
        String directoryPath = scanner.nextLine();

        // get the directory object
        File directory = new File(directoryPath);

        // get all the files in the directory
        File[] files = directory.listFiles();

        // print out the names of each file
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files in directory");
        }

        // close the scanner
        scanner.close();
    }
}