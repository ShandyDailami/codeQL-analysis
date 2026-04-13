import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05827_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "path_to_directory";  // replace with actual directory path
        String searchString = "A07_AuthFailure";

        File directory = new File(directoryPath);

        // Iterate over all files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Check if the line contains the search string
                            if (line.contains(searchString)) {
                                System.out.println("File: " + file.getName() + " contains the string: " + searchString);
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}