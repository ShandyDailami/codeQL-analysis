import java.io.*;

public class java_14020_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("path_to_your_file");
        try (FileScanner scanner = new FileScanner(file)) {
            String searchString = "search_string";
            System.out.println("Searching for string: " + searchString);

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.contains(searchString)) {
                    System.out.println("Found string: " + line);
                }
            }

            System.out.println("Finished searching file.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

class FileScanner implements AutoCloseable {
    private BufferedReader reader;

    public java_14020_FileScanner_A01(File file) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(file));
    }

    public String nextLine() throws IOException {
        return reader.readLine();
    }

    public boolean hasNext() throws IOException {
        return reader.ready();
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}