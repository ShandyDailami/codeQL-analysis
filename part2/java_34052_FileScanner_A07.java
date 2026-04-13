import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34052_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "path_to_your_directory"; // replace with your directory path
        String fileName = "file_to_search.txt"; // replace with your file name

        File directory = new File(directoryPath);

        // Use a Scanner to read the file name from the directory
        try (Scanner scanner = new Scanner(directory)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase(fileName)) {
                    System.out.println("File found!");
                    return; // exit the program if the file is found
                }
            }
        }

        System.out.println("File not found!");
    }
}