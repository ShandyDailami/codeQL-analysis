import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_19795_FileScanner_A03 {

    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";

    public static void main(String[] args) {
        File file = new File(INPUT_FILE_PATH);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}