import java.io.*;
import java.util.Scanner;

public class java_29370_FileScanner_A07 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("path_to_your_file"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("pattern")) {
                    System.out.println("Found line: " + line);
                    // If you want to delete the line, uncomment the following line:
                    // System.out.println("Deleting line: " + line);
                    // System.out.println("Deleted line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}