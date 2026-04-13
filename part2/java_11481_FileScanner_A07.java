import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11481_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "path_to_your_directory"; // replace with your directory path
        String extension = ".txt"; // replace with the file extension you want to scan

        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}