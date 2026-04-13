import java.io.*;

public class java_03745_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("/path/to/directory");

        try (FileScanner scanner = new FileScanner(file)) {
            while (scanner.hasNext()) {
                String path = scanner.next();
                System.out.println("Scanning: " + path);

                // Check if file is hidden or not readable
                if (new File(path).isFile() &&
                    ((new File(path)).setReadable(true, false)) {
                    // Security-sensitive operation: check if the file is writable
                    if (!((new File(path)).setWritable(true, false))) {
                        System.out.println("AuthFailure: " + path);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}