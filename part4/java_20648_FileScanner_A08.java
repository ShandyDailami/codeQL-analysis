import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20648_FileScanner_A08 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        String fileExtension = "txt";  // replace with your file extension

        try (FileScanner fileScanner = new FileScanner(directoryPath, fileExtension)) {
            while (fileScanner.hasNext()) {
                String filePath = fileScanner.next();
                System.out.println("Processing file: " + filePath);

                // Process the file here
                // For example, read the file and print its content
                try (Scanner fileScanner = new Scanner(new File(filePath))) {
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                }

                System.out.println("Finished processing file: " + filePath);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + directoryPath);
        }
    }
}