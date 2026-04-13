import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class java_05528_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("example.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();

        // Writing to a file
        PrintWriter writer = new PrintWriter("example.txt");
        writer.println("This is a new line");
        writer.close();
    }
}