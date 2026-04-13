import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15195_FileScanner_A03 {

    public static void main(String[] args) {
        // Create a file scanner for a specific directory.
        File dir = new File("C:\\Users\\User\\Documents");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a file name to search in the directory:");
        String filename = scanner.nextLine();

        File file = new File(dir, filename);

        try {
            // Use the file scanner to find the file.
            if (file.exists()) {
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
            } else {
                System.out.println("File not found.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Always close the scanner.
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}