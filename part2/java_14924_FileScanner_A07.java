import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_14924_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "/path/to/directory";
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    readFile(file);
                }
            }
        }
    }

    public static void readFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}