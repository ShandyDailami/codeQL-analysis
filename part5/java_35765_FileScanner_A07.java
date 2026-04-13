import java.io.*;

public class java_35765_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("input.txt");
        File outputFile = new File("output.txt");

        try (FileReader reader = new FileReader(file); FileWriter writer = new FileWriter(outputFile)) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character);
            }
            System.out.println("File reading completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}