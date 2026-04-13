import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class java_13117_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(".");
        File[] listOfFiles = file.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                readFile(listOfFiles[i]);
            }
        }
    }

    private static void readFile(File file) throws FileNotFoundException {
        // Using FileReader to read the file, this has better performance than using FileInputStream
        // and it is simpler to use
        FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}