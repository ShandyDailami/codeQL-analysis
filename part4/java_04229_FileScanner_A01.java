import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_04229_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File testFile = new File("test.txt");
            Scanner fileScanner = new Scanner(testFile);

            while(fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}