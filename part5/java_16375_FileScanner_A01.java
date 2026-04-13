import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16375_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        File[] textFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

        if (textFiles != null) {
            for (File textFile : textFiles) {
                Scanner scanner = new Scanner(textFile);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Do something with the line (e.g., print it)
                    System.out.println(line);
                }
                scanner.close();
            }
        }
    }
}