import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class java_27700_FileScanner_A03 {

    public static void main(String[] args) throws IOException {
        // Read file
        Path path = Paths.get("input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        // Write to file
        Path outputPath = Paths.get("output.txt");
        FileWriter writer = new FileWriter(outputPath.toFile());
        writer.write("This is a secure operation!");
        writer.close();
    }
}