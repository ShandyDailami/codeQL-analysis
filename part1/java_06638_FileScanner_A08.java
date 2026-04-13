import java.io.*;

public class java_06638_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("C:\\Users\\your_folder\\file.txt"); // replace with your file path
            FileReader reader = new FileReader(file);
            int c;

            while ((c = reader.read()) != -1) {
                if (c == 0x0A) { // ASCII value of newline character
                    System.out.println("Integrity failure detected!");
                    // Add your security-sensitive operations here
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println("Error reading file!");
        }
    }
}