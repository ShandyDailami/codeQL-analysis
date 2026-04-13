import java.io.*;

public class java_35102_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("path_to_file");
        try (FileReader reader = new FileReader(file)) {
            int c;
            while ((c = reader.read()) != -1) {
                if (c == 'A' || c == 'a') {
                    continue;
                }
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}