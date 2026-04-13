import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class java_16779_FileScanner_A01 {

    public static void main(String[] args) {
        String filePath = "/path/to/file.ext"; // replace with your file path
        String extension = ".ext"; // replace with your file extension
        scanFile(filePath, extension);
    }

    public static void scanFile(String filePath, String extension) {
        try (FileInputStream fis = new FileInputStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.endsWith(extension)) {
                    System.out.println("Found file: " + line);
                    printFileContent(filePath);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
    }

    public static void printFileContent(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
    }
}