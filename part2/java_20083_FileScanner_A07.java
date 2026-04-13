import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class java_20083_FileScanner_A07 {

    public static void main(String[] args) {
        File file = new File("src/main/resources/text.txt");
        FileScanner(file);
    }

    public static void FileScanner(File file) {
        try {
            FileReader reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        } catch (IOException e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}