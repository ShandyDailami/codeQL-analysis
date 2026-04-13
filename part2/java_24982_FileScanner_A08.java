import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class java_24982_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File("input.txt");
        Scanner scanner = null;
        FileWriter writer = null;
        try {
            scanner = new Scanner(file);
            scanner.useDelimiter("\\Z");
            String contents = scanner.next();
            writer = new FileWriter("output.txt");
            writer.write(contents.toUpperCase());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}