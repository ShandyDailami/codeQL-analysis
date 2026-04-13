import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08891_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt"); // replace with your file path
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }
        
        scanner.close();
    }
}