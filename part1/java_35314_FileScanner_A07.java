import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_35314_FileScanner_A07 {

    public static void main(String[] args) {

        String searchString = "authFailure";

        File folder = new File("C:\\path_to_your_directory");

        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains(searchString)) {
                            System.out.println("File: " + file.getName() + " contains the string: " + searchString);
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}