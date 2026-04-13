import java.io.*;

public class java_31025_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file");
            FileReader fr = new FileReader(file);
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}