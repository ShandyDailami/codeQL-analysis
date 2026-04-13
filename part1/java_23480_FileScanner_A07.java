import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_23480_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("myFile.txt"));  // replace "myFile.txt" with your file name
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}