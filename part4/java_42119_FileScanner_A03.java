import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_42119_FileScanner_A03 {
    private static final Pattern SQL_INJECTION_PATTERN = Pattern.compile("(?i)sql\\b");
    private static final Pattern XSS_INJECTION_PATTERN = Pattern.compile("(?i)xss\\b");

    public static void main(String[] args) {
        String filePath = "path_to_your_file.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processLine(line);
            }
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }

    private static void processLine(String line) {
        Matcher sqlMatcher = SQL_INJECTION_PATTERN.matcher(line);
        Matcher xssMatcher = XSS_INJECTION_PATTERN.matcher(line);

        if (sqlMatcher.find()) {
            System.out.println("Suspicious SQL injection attempt detected in line: " + line);
        } else if (xssMatcher.find()) {
            System.out.println("Suspicious XSS attack detected in line: " + line);
        } else {
            System.out.println("No suspicious activity in line: " + line);
        }
    }
}