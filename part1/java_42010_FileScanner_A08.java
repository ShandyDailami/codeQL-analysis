import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_42010_FileScanner_A08 {
    public static void main(String[] args) {
        String target = "error"; // This should be the text you're looking for
        String path = "path_to_file"; // Replace with your path to file

        File file = new File(path);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(target)) {
                    System.out.println("Error detected in file: " + file.getPath());
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
            e.printStackTrace();
        }
    }
}