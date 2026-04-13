import java.io.*;
import java.util.*;

public class java_20746_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("target.txt"); // replace with your file path
        Scanner scanner = new Scanner(System.in);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.contains("injection")) {
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}