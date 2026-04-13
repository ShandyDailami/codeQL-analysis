import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.InvalidParameterException;

public class java_25355_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("path/to/file");
        try (InputStream inputStream = new FileInputStream(file)) {
            // Read file content here
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (InvalidParameterException e) {
            System.out.println("Invalid parameter: " + e.getMessage());
        }
    }

}