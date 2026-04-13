import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40862_FileScanner_A08 {

    public static void main(String[] args) {
        String fileName = "A08_IntegrityFailure.txt";
        File file = new File(fileName);

        // If file does not exist, throw an exception
        if (!file.exists()) {
            throw new RuntimeException("File does not exist: " + fileName);
        }

        try (Scanner scanner = new Scanner(file)) {
            // Keep scanning until we find the file
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}