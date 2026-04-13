import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20208_FileScanner_A03 {

    public static void main(String[] args) {
        String targetString = "A03_Injection";
        File file = new File("target/file.txt");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(targetString)) {
                    System.out.println("Found line containing target string: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}