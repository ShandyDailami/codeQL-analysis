import java.io.*;

public class java_19211_FileScanner_A08 {
    private static final String FILE_PATH = "src/main/resources/A08_IntegrityFailure.txt";

    public static void main(String[] args) {
        try (FileScanner fileScanner = new FileScanner()) {
            fileScanner.startScanning();
            fileScanner.readFile();
            fileScanner.stopScanning();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class FileScanner implements AutoCloseable {
        private FileReader reader;

        @Override
        public void close() throws IOException {
            reader.close();
        }

        public void startScanning() throws IOException {
            reader = new FileReader(FILE_PATH);
        }

        public void readFile() throws IOException {
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
        }

        public void stopScanning() throws IOException {
            reader.close();
        }
    }
}