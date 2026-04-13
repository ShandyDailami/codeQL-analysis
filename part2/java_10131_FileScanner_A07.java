import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class java_10131_FileScanner_A07 {

    public static void main(String[] args) {
        String filePath = "path_to_your_file";
        String searchTerm = "A07_AuthFailure";
        countOccurrences(filePath, searchTerm);
    }

    public static void countOccurrences(String filePath, String searchTerm) {
        Pattern pattern = Pattern.compile(searchTerm);
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Occurrences of '" + searchTerm + "': " + count);
    }
}