import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class java_19971_FileScanner_A01 {
    public static void main(String[] args) {
        String inputFilePath = "/path/to/input/file.txt";
        String outputFilePath = "/path/to/output/file.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             FileWriter writer = new FileWriter(outputFilePath)) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Filter out certain lines
                if (!line.startsWith("Filtered out line")) {
                    writer.write(line);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}