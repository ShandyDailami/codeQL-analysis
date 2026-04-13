import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_36841_FileScanner_A07 {
    public static void main(String[] args) {
        String fileName = "example.txt";
        String targetWord = "AuthFailure";
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(targetWord)) {
                    count++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("The word '" + targetWord + "' was found " + count + " times in the file.");
    }
}