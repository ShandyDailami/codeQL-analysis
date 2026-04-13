import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18309_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "src/main/resources";
        String fileName = "A07_AuthFailure.txt";

        File file = new File(directory, fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // handle the line here, for example by logging it
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}