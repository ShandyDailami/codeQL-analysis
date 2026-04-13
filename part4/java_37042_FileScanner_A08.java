import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37042_FileScanner_A08 {
    public static void main(String[] args) {
        String filePath = "/path/to/your/file.txt"; // replace with your file path
        String searchString = "your_search_string"; // replace with your search string

        try {
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);

            System.out.println("Lines containing '" + searchString + "' are:");

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains(searchString)) {
                    System.out.println(line);
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}