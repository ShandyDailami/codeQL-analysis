import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08124_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        // create a new File object
        File file = new File("src/main/resources/");

        // create a new Scanner object
        Scanner scanner = new Scanner(file);

        // use a while loop to scan through the files in the directory
        while (scanner.hasNextLine()) {
            // get the next line
            String line = scanner.nextLine();

            // print out the name of the file
            System.out.println(line);
        }

        // close the scanner
        scanner.close();
    }
}