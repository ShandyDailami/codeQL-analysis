import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class java_32715_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            // Create a File object for the current Java application
            File file = new File(".");

            // Get the name of the file to read
            String fileName = "test.txt";

            // Create a FileInputStream object for the file
            FileInputStream fileInputStream = new FileInputStream(file.getCanonicalPath() + "/" + fileName);

            // Read the file contents
            int content;
            while ((content = fileInputStream.read()) != -1) {
                System.out.print((char) content);
            }

            // Close the FileInputStream
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}