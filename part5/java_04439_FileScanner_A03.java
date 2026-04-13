import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class java_04439_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file"); // replace with your file path
            FileInputStream fis = new FileInputStream(file);

            // read file content
            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }

            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error reading file!");
        }
    }
}