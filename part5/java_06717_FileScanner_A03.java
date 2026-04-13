import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06717_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File("./src/main/resources"); // Change this to your directory
        String[] files = directory.list(); // Get a list of all files in the directory

        for (String file : files) { // Loop through each file
            File fileObj = new File(directory + "/" + file);

            try (Scanner scanner = new Scanner(fileObj)) { // Try to open the file for reading
                while (scanner.hasNextLine()) { // While there's more content in the file...
                    System.out.println(scanner.nextLine()); // Print the content
                }
            }
        }
    }
}