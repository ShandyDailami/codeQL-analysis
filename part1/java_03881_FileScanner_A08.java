import java.io.*;

public class java_03881_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        try (FileReader reader = new FileReader(file)) {
            int lineNumber = 0;
            int charNumber = 0;

            int c;
            while ((c = reader.read()) != -1) {
                charNumber++;
                if (c == '\n') {
                    lineNumber++;
                    charNumber = 0;
                }
           
                System.out.println("Line " + lineNumber + ", Char " + charNumber + ": " + c);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}