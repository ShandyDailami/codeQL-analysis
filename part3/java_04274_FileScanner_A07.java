import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class java_04274_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String filePath = "/path/to/file";

        try {
            readFile(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writeToFile(new File(filePath), "This is a test!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readAndPrintFromFile(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(File file) throws IOException {
        FileReader reader = new FileReader(file);
        int character;

        while ((character = reader.read()) != -1) {
            System.out.print((char) character);
        }

        reader.close();
    }

    private static void writeToFile(File file, String content) throws IOException {
        RandomAccessFile writer = new RandomAccessFile(file, "rw");
        writer.writeBytes(content.getBytes(StandardCharsets.UTF_8));
        writer.close();
    }

    private static void readAndPrintFromFile(File file) throws IOException {
        FileReader reader = new FileReader(file);
        int character;

        while ((character = reader.read()) != -1) {
            System.out.print((char) character);
        }

        reader.close();
    }
}