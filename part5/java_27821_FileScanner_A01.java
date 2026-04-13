import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27821_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File("."); // current directory

        // Use FileScanner to list files in the directory
        FileScanner fs = new FileScanner(directory);
        fs.start();

        try (Scanner scanner = new Scanner(fs.getFile())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        fs.stop();
    }

}