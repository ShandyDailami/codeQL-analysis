import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40548_FileScanner_A03 {
    private static final String DIRECTORY = "C:\\Users\\User\\Documents\\";
    private static final String FILENAME = "sample.txt";

    public static void main(String[] args) {
        String filePath = DIRECTORY + FILENAME;
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }
}