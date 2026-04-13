import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_34348_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // create a file scanner
        FileScanner scanner = new FileScanner("src/main/resources/test.txt");

        // start scanning from the beginning of the file
        scanner.reset();

        // scan the file
        while (scanner.hasNext()) {
            // get the next line
            String line = scanner.nextLine();

            // print the line
            System.out.println(line);
        }

        // close the scanner
        scanner.close();
    }
}