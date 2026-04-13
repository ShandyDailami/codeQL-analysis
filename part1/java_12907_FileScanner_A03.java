import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12907_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new File("C:\\path\\to\\your\\file"));
            while (s.hasNextLine()) {
                String line = s.nextLine();
                // This is where the injection point is
                System.exec(line);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}