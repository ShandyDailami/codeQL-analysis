import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_37950_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
       
        }

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}