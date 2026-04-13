import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36782_FileScanner_A03 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/main/resources/injection.txt"));
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