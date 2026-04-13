import java.io.*;

public class java_31623_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        File file = new File("path_to_your_file");
        FileReader reader = new FileReader(file);
        FileWriter writer = new FileWriter(file, false); // Append mode is set to false

        int ch;
        while ((ch = reader.read()) != -1) {
            if (ch == 'A' || ch == 'a') {
                // Changing content to a different character
                writer.write('B');
            } else {
                writer.write(ch);
            }
        }

        reader.close();
        writer.close();
    }
}