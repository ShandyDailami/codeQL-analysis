import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39454_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/file.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}