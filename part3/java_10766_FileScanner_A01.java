import java.io.*;

public class java_10766_FileScanner_A01 {
    public static void main(String[] args) {
        String inputFilePath = "/path/to/input/file";
        String outputFilePath = "/path/to/output/file";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.contains("BrokenAccessControl")) {
                    writer.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}