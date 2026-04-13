import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_09956_FileScanner_A03 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("injection.txt"));
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}