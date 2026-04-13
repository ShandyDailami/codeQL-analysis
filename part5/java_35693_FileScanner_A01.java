import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35693_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        // Specify the directory to scan and the file name
        File directory = new File(".");
        File targetFile = new File("target.txt");

        // Initialize a FileNotFoundException
        boolean fileFound = false;

        // Use a FileFilter to only include files with the specific name
        File[] foundFiles = directory.listFiles((File pathname) -> {
            return pathname.getName().equals(targetFile.getName());
        });

        // Scan the file
        if (foundFiles.length > 0) {
            fileFound = true;
            Scanner fileScanner = new Scanner(foundFiles[0]);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();
        }

        // If file not found, print a message
        if (!fileFound) {
            System.out.println("File not found.");
        }
    }
}