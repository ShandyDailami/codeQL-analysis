import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_14151_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            String[] directoryContents = directory.list();
            for (String fileName : directoryContents) {
                File file = new File(directoryPath + "/" + fileName);
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
                fileScanner.close();
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }
    }
}