import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_20237_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String txtExtension = ".txt";

        System.out.println("Listing all .txt files in the current directory:");

        // Use the FileScanner to list all files that match the .txt extension.
        // This will throw an exception if the user does not have permission to access the directory.
        try (Scanner scanner = new Scanner(directory.listFiles((dir, name) -> name.endsWith(txtExtension)))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        }
    }
}