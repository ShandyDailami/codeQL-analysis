import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10326_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        String targetDirectory = "/path/to/target/directory";
        File directory = new File(targetDirectory);
        File[] secureFiles = directory.listFiles((dir, name) -> name.matches(".*\\.jpg.*"));

        for (File file : secureFiles) {
            System.out.println("Found secure file: " + file.getPath());

            // Assume we have a method called readFile to read a file
            readFile(file);
        }
    }

    private static void readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println("Read line: " + line);
        }
        scanner.close();
    }
}