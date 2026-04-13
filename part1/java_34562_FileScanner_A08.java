import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34562_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\User\\Desktop\\test.txt"));
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