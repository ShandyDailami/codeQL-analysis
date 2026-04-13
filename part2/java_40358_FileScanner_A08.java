import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40358_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File("."); // Current directory
        String[] list = directory.list(); // list all files in directory

        // Only files starting with 'A' will be printed
        for (String filename : list) {
            if (filename.startsWith("A")) {
                try (Scanner scanner = new Scanner(new File(filename))) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + filename);
                }
            }
        }
    }
}