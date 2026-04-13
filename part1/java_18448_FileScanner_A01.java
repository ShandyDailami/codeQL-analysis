import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18448_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("path/to/file.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line); // Prints the file content
        }

        scanner.close();
    }

}