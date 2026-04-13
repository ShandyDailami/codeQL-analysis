import java.io.*;

public class java_12996_FileScanner_A07 {
    public static void main(String[] args) {
        File fileIn = new File("sample.txt");
        File fileOut = new File("sample_out.txt");

        try (FileReader reader = new FileReader(fileIn);
             FileWriter writer = new FileWriter(fileOut)) {

            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}