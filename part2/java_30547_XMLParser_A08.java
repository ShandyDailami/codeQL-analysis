import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class java_30547_XMLParser_A08 {
    public static void main(String[] args) {
        // Read the XML file
        try (InputStream in = new FileInputStream("example.xml")) {
            // Create a BufferedReader to read the file
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            // Read the XML file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}