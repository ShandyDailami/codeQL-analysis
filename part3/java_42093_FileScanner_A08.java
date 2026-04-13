import java.io.*;

public class java_42093_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        File file = new File("./target/A08_IntegrityFailure.txt");
        FileScanner scanner = new FileScanner(file);

        if (file.exists()) {
            if (!file.canRead()) {
                throw new SecurityException("File is not readable");
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                // Process the line
                // For now, just print it out
                System.out.println(line);
            }

            reader.close();
        } else {
            throw new FileNotFoundException("File not found");
        }
    }
}

class FileScanner {
    private File file;

    public java_42093_FileScanner_A08(File file) {
        this.file = file;
    }

    public void readFile() throws IOException {
        if (file.exists()) {
            if (!file.canRead()) {
                throw new SecurityException("File is not readable");
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                // Process the line
                // For now, just print it out
                System.out.println(line);
            }

            reader.close();
        } else {
            throw new FileNotFoundException("File not found");
        }
    }
}