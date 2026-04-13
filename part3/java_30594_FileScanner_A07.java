import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_30594_FileScanner_A07 {
    public static void main(String[] args) {
        String fileName = "/path/to/your/file";
        String searchTerm = "A07_AuthFailure";
        int count = 0;

        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(searchTerm)) {
                    count++;
                }
            }
            scanner.close();

            System.out.println("The file contains " + count + " occurrences of '" + searchTerm + "'.");
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found.");
        }
    }
}