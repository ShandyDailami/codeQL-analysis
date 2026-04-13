import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class java_40934_FileScanner_A01 {
    private static final String DIRECTORY_PATH = "path_to_your_directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);

        try (FileReader reader = new FileReader(directory);
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("The specified file was not found.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred while reading the file.");
        }
    }
}