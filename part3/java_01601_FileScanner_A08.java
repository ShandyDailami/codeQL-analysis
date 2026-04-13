import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_01601_FileScanner_A08 {

    public static void main(String[] args) {
        try {
            File file = new File("yourfile.txt"); // replace "yourfile.txt" with your file path
            Scanner scanner = new Scanner(file);
            
            while(scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}