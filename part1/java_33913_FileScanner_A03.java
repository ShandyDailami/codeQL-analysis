import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33913_FileScanner_A03 {

    // Parameterized query function
    public static void scanFile(String filePath, String query) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);

        System.out.println("Scanning file: " + file.getPath());

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(query)) {
                System.out.println("Found query in line: " + line);
            }
        }

        scanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "path_to_your_file.txt";
        String query = "your_query";

        scanFile(filePath, query);
    }
}