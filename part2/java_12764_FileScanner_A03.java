import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12764_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "C:\\"; // replace with your directory path
        String searchString = "password"; // replace with your search string

        File dir = new File(directoryPath);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) { // check if it's a text file
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains(searchString)) {
                                System.out.println("Found line containing '" + searchString + "' in " + file.getPath());
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