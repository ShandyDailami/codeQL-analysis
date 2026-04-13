import java.io.*;  // Import File I/O and Serialization classes
import java.util.*;  // Import various container classes

public class java_36849_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\path\\to\\your\\file.txt");

            // Use FileInputStream for reading a file
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error reading file!");
        }
    }
}