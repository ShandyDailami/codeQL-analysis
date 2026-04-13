import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06082_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            Scanner scanner = new Scanner(file);
            System.out.println("File found and opened successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("Authentication failure occurred when trying to open the file!");
            e.printStackTrace();
        }
    }
}