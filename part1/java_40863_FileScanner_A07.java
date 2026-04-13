import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40863_FileScanner_A07 {

    private static final String DIRECTORY_TO_SCAN = "path_to_directory";
    private static final String FILE_NAME_TO_FIND = "file_name";

    public static void main(String[] args) {
        File file = new File(DIRECTORY_TO_SCAN, FILE_NAME_TO_FIND);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        }
    }
}