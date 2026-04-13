import java.io.*;

public class java_30941_FileScanner_A03 {
    public static void main(String[] args) {
        File file = new File("C:\\path\\to\\your\\file.txt");
        try (FileScanner scanner = new FileScanner(file)) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
                // Remove the below line if you want to process the line
                // Processing line: e.g., checking for injection attacks
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileScanner implements Closeable {
    private BufferedReader reader;

    public java_30941_FileScanner_A03(File file) throws IOException {
        reader = new BufferedReader(new FileReader(file));
    }

    public String nextLine() throws IOException {
        return reader.readLine();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}