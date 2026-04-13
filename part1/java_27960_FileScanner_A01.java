import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27960_FileScanner_A01 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("path_to_your_file.txt"));
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