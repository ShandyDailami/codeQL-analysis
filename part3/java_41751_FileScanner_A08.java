import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41751_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String folderPath = "/path/to/directory"; // replace with your directory
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                }
            }
        } else {
            System.out.println("No files found in the directory.");
        }
    }
}