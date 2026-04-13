import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_29434_FileScanner_A03 {

    public static void main(String[] args) {
        String fileName = "C:/path/to/your/file.txt";
        scanFile(fileName);
    }

    private static void scanFile(String fileName) {
        long lineCount = 0;
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                lineCount++;
                System.out.println("Line " + lineCount + " of " + fileName);
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
        }
        System.out.println("File " + fileName + " has been read and displayed, total lines: " + lineCount);
    }
}