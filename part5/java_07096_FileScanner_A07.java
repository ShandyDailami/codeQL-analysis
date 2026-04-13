import java.io.*;

public class java_07096_FileScanner_A07 {

    public static void main(String[] args) {
        String filePath = "/path/to/file.txt";
        File file = new File(filePath);

        try (FileReader reader = new FileReader(file);
             FileWriter writer = new FileWriter(file, true)) {

            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}