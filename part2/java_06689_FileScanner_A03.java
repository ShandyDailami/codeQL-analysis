import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_06689_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/java/");
        scanFiles(file);
    }

    public static void scanFiles(File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            File[] listOfFiles = file.listFiles();
            for (File tempFile : listOfFiles) {
                scanFiles(tempFile);
            }
        } else if (file.getName().endsWith(".java")) {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("a03_injection")) {
                    System.out.println(line);
                }
            }
            scanner.close();
        }
    }
}