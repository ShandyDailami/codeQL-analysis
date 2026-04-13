import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38123_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/BrokenAccessControlFile.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Here, we're just printing the line to the console.
                // In a real-world scenario, you'd likely do something more useful with the line.
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}