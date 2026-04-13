import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class java_12784_FileScanner_A01 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.initialize("example.txt");
        List<String> names = scanner.readNames();
        for (String name : names) {
            System.out.println("Accessed by: " + name);
        }
    }

    public static class FileScanner {
        private List<String> names = new ArrayList<>();

        public void initialize(String filename) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    names.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public List<String> readNames() {
            return names;
        }
    }
}