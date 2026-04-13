import java.io.*;

public class java_00723_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_file"); // replace with your file path
            FileReader reader = new FileReader(file);

            int ch;
            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}