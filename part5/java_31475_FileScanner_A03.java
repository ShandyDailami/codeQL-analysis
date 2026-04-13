import java.io.*;
import java.util.*;

public class java_31475_FileScanner_A03 {
    private List<String> injections = new ArrayList<>();

    public List<String> getInjections() {
        return injections;
    }

    public void scanFile(String filePath) {
        try (FileScanner scanner = new FileScanner(new File(filePath))) {
            while (scanner.hasNext()) {
                injections.add(scanner.next());
            }
        } catch (IOException e) {
            System.err.println("Error scanning file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        InjectFile injectFile = new InjectFile();
        injectFile.scanFile("/path/to/your/file");
        List<String> injections = injectFile.getInjections();
        for (String injection : injections) {
            System.out.println(injection);
        }
    }
}