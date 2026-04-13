import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_23951_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            // Define the path
            Path path = Paths.get("path_to_your_file");

            // Check if the file exists
            if (Files.exists(path)) {
                File file = path.toFile();

                // Print the file name
                System.out.println("File Name: " + file.getName());

                // Print the file size
                System.out.println("File Size: " + file.length() + " bytes");
            } else {
                System.out.println("File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}