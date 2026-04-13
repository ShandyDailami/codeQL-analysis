import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class java_22277_FileScanner_A08 {

    public static void main(String[] args) {
        try {
            // Open the file for reading
            FileInputStream fis = new FileInputStream("path_to_file");
            
            // Create a BufferedReader to read the file line by line
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            
            String line;
            // Read the file line by line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            
            // Close the file
            br.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}