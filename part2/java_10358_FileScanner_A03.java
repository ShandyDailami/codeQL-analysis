import java.io.File;
import java.util.Scanner;

public class java_10358_FileScanner_A03 {

    public static void main(String[] args) {
        String searchString = "searchThisString"; // This string is what we're looking for

        try {
            File file = new File("path/to/your/file.txt"); // Replace with your file path
            Scanner scanner = new Scanner(file);

            System.out.println("Searching for '" + searchString + "' in the file:");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchString)) {
                    System.out.println("Found in line: " + line);
                }
            }

            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}