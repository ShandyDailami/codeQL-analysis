import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_01451_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String directory = "/path/to/directory"; // replace with your directory path
        String searchString = "your search string"; // replace with your search string

        File dir = new File(directory);

        if (dir.exists() && dir.isDirectory()) {
            File[] listOfFiles = dir.listFiles();

            for (File file : listOfFiles) {
                if (file.isFile() && file.canRead()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains(searchString)) {
                            System.out.println("File: " + file.getPath() + ", Line: " + (line.contains(searchString) ? "Found" : "Not Found"));
                        }
                    }
                    scanner.close();
                }
            }
        } else {
            System.out.println("The specified directory does not exist or is not a directory.");
        }
    }
}