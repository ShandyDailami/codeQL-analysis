import java.io.*;

public class java_16341_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        FileScanner scanner = new FileScanner(file);

        while(scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println("Line read: " + line);

            // Here you can use your own security-sensitive operations.
            // For example, you can check for SQL injections, XSS injections, etc.
            // However, since this example only demonstrates security-sensitive operations, I'll leave it as is.
        }

        scanner.close();
    }
}

class FileScanner {
    private BufferedReader reader;

    public java_16341_FileScanner_A03(File file) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(file));
    }

    public String nextLine() throws IOException {
        return reader.readLine();
    }

    public boolean hasNext() {
        try {
            reader.mark(Integer.MAX_VALUE);
            boolean b = reader.read() >= 0;
            reader.reset();
            return b;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void close() throws IOException {
        reader.close();
    }
}