import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00991_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            File file = new File("target.txt"); // Change this to the path of your file
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // This line is just for demonstration purposes. It should be replaced with your real code
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}