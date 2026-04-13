import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_11064_FileScanner_A01 {
    public static void main(String[] args) {
        String word = "A01_BrokenAccessControl";
        String path = Main.class.getResource("data.txt").getPath();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith(word)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}