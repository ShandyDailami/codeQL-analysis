import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_18951_FileScanner_A08 {
    public static void main(String[] args) {
        try {
            File file = new File("myFile.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}