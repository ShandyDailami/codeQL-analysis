import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_33773_FileScanner_A07 {
    public static void main(String[] args) {
        String filePath = "/path/to/your/file.txt"; // Replace with your file path
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processLine(String line) {
        Pattern pattern = Pattern.compile("AuthFailure");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            System.out.println("Suspicious activity detected in line: " + line);
        }
    }
}