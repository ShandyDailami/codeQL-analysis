import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25086_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        File rootDirectory = new File(".");
        findFile(rootDirectory, "A08_IntegrityFailure.txt");
    }

    private static void findFile(File directory, String filename) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findFile(file, filename);
                } else if (file.getName().equals(filename)) {
                    Scanner scanner = new Scanner(file);
                    int lineNumber = 1;
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println("Line " + lineNumber + ": " + line);
                        lineNumber++;
                    }
                    scanner.close();
                }
            }
        }
    }
}