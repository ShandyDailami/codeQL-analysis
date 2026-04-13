import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_21960_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        // Ask for directory
        System.out.println("Please enter a directory:");
        String directoryPath = scanner.next();

        // Ask for file
        System.out.println("Please enter a file:");
        String fileName = scanner.next();

        // Construct file paths
        File directory = new File(directoryPath);
        File file = new File(directory, fileName);

        // Check if file exists and if it can be read
        if (file.exists() && file.canRead()) {
            System.out.println("Reading file: " + file.getAbsolutePath());

            Scanner fileScanner = new Scanner(file);

            // Print each line of the file
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

            fileScanner.close();
        } else {
            System.out.println("Could not access file or directory.");
        }
    }
}