import java.io.*;
import java.nio.file.*;

public class java_21185_FileScanner_A07 {
    private static final String FILE_PATH = "path/to/file.txt";

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(FILE_PATH);
        if (Files.exists(path)) {
            if (Files.isReadable(path)) {
                BufferedReader reader = Files.newBufferedReader(path);
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } else {
                System.out.println("The file is not readable.");
            }
        } else {
            System.out.println("The file does not exist.");
        }
    }
}