import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12339_FileScanner_A03 {

    public static void main(String[] args) {
        File folder = new File("."); // This will be the current directory
        String extension = ".txt";

        System.out.println("Searching for files with extension: " + extension);

        File[] listOfFiles = folder.listFiles((dir, name) -> name.endsWith(extension));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No files found with extension: " + extension);
        }
    }
}