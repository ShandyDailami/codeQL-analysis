import java.io.*;

public class java_33237_FileScanner_A07 {
    public static void main(String[] args) {
        try (FileScanner scanner = new FileScanner()) {
            scanner.scan("path_to_your_file", (line) -> {
                if (line.contains("your_string_to_stop_at")) {
                    System.out.println("Stopped at: " + line);
                    scanner.stop(); // Stop the scanner after the first line that contains the string
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}