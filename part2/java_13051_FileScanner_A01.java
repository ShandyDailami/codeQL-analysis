import java.io.*;
import java.util.*;

public class java_13051_FileScanner_A01 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory";
        String word = "sensitive";

        File directory = new File(directoryPath);

        FileScanner fileScanner = new FileScanner(directory, word);

        fileScanner.startScanning();

        System.out.println("Lines containing word: " + word);

        while (fileScanner.hasNextLine()) {
            System.out.println(fileScanner.nextLine());
        }

        fileScanner.stopScanning();
    }
}

class FileScanner {
    private File directory;
    private String word;
    private BufferedReader reader;

    public java_13051_FileScanner_A01(File directory, String word) throws FileNotFoundException {
        this.directory = directory;
        this.word = word;

        this.reader = new BufferedReader(new FileReader(directory));
    }

    public void startScanning() throws IOException {
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.contains(word)) {
                System.out.println(line);
            }
        }
    }

    public void stopScanning() throws IOException {
        reader.close();
    }

    public boolean hasNextLine() throws IOException {
        return reader.ready();
    }

    public String nextLine() throws IOException {
        return reader.readLine();
    }
}