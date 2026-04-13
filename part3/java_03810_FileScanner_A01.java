import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03810_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "path/to/directory"; // replace with your directory path
        File directory = new File(directoryPath);
        
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist or is not a directory.");
            return;
        }
        
        try (Scanner scanner = new Scanner(new File("path/to/input.txt"))) { // replace with your input file path
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line); // replace with your own processing logic
            }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        }
    }
}