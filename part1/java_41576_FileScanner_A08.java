import java.io.*;

public class java_41576_FileScanner_A08 {
    public static void main(String[] args) {
        String inputFilePath = "/path/to/input/file.txt";
        String outputFilePath = "/path/to/output/file.txt";

        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);

        try (FileReader reader = new FileReader(inputFile); FileWriter writer = new FileWriter(outputFile)) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing to the file.");
            e.printStackTrace();
        }
    }
}