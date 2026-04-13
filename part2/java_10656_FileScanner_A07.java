import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10656_FileScanner_A07 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Change this to your directory path
        String searchString = "your search string"; // Change this to your search string

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        try (Scanner scanner = new Scanner(file)) {
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();

                                if (line.contains(searchString)) {
                                    System.out.println("File: " + file.getPath() + " contains the string: " + searchString);
                                }
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}