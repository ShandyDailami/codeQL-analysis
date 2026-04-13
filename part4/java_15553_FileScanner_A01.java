import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class java_15553_FileScanner_A01 {

    public static void main(String[] args) {
        File file = new File("path_to_your_file.txt");
        FileScanner scanner = new FileScanner(file);

        try {
            System.out.println("Number of words in the file: " + scanner.countWords());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

class FileScanner {

    private File file;

    public java_15553_FileScanner_A01(File file) {
        this.file = file;
    }

    public int countWords() throws IOException {
        FileReader reader = new FileReader(file);
        int count = 0;
        int c = 0;
        while ((c = reader.read()) != -1) {
            if (c == ' ') {
                count++;
            }
        }
        reader.close();
        return count;
    }
}