import java.io.File;
import java.util.Scanner;

public class java_23704_FileScanner_A03 {

    public static void main(String[] args) {
        // Create a File object for the current directory
        File file = new File(".");

        // Create a Scanner to read from the directory
        try (Scanner scanner = new Scanner(file.getAbsoluteFile())) {
            // Print out the names of all files in the directory
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}