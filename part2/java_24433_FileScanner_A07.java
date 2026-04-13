import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24433_FileScanner_A07 {
    public static void main(String[] args) {
        String directory = "."; // replace with the directory you want to scan
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String data = scanner.nextLine();
                        System.out.println(data);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found: " + file.getName());
                }
                break; // only process the first file in the directory
            }
        }
    }
}