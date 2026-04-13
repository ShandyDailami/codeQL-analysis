import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_24499_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("sample.txt");
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}