import java.io.*;
import java.nio.file.*;

public class java_34771_FileScanner_A08 {
    public static void main(String[] args) {
        Path source = Paths.get("src/main/resources/sourcefile.txt");
        Path target = Paths.get("src/main/resources/targetfile.txt");

        try (BufferedReader reader = new BufferedReader(Files.newReader(source));
             PrintWriter writer = new PrintWriter(Files.newBufferedWriter(target))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}