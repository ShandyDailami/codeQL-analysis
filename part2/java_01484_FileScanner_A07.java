import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01484_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // Get the current directory
        File currentDir = new File(".");

        // Use FileScanner to iterate over all files in the current directory and its subdirectories
        Scanner fileScanner = new Scanner(currentDir);
        while (fileScanner.hasNext()) {
            String fileName = fileScanner.next();
            // Check if the file is a directory
            if (new File(fileName).isFile()) {
                // Print the file name
                System.out.println(fileName);
            }
        }
        fileScanner.close();
    }
}