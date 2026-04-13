import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28308_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        // Prompt the user to enter a directory
        System.out.print("Enter a directory: ");
        Scanner input = new Scanner(System.in);
        String directory = input.next();

        // Create a new File object and get all files in it
        File filesInDirectory = new File(directory);
        File[] listOfFiles = filesInDirectory.listFiles();

        // Print all files
        if (listOfFiles != null) {
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    System.out.println(listOfFiles[i].getName());
                }
            }
        } else {
            System.out.println("No files found in the directory!");
        }

        input.close();
    }
}