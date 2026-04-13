import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_28611_FileScanner_A07 {
    private static final String DIR_PATH = "path_to_directory"; // provide a path to the directory
    private static final String FILE_NAME = "file_name"; // provide a file name

    public static void main(String[] args) {
        File dir = new File(DIR_PATH);
        if (dir.isDirectory()) {
            File file = new File(dir, FILE_NAME);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    // process the line here, e.g. check for authentication failure
                    if (line.contains("auth_fail")) {
                        System.out.println("Authentication failure detected!");
                        // perform security sensitive operations here
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.out.println("Directory not found: " + DIR_PATH);
        }
    }
}