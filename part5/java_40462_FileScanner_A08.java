import java.io.File;
import java.util.Scanner;

public class java_40462_FileScanner_A08 {
    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();

        // If you want to read files in a specific directory, replace '/path/to/directory' with your directory path.
        scanner.startScan('/path/to/directory');
    }
}

class FileScanner {
    private File file;
    private Scanner scanner;

    public java_40462_FileScanner_A08() {
        file = new File(".");
        scanner = new Scanner(System.in);
    }

    public void startScan(String path) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isFile() && f.canRead()) {
                    try {
                        scannerFile(f);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (f.isDirectory()) {
                    startScan(f.getPath());
                }
            }
        } else {
            System.out.println("This is not a directory!");
        }
    }

    private void scannerFile(File file) {
        try {
            scanner.useDelimiter("\\Z");
            String contents = new String(java.nio.file.Files.readAllBytes(file.toPath()));
            if (contents.contains("A08_IntegrityFailure")) {
                System.out.println("File contains 'A08_IntegrityFailure' in its content: " + file.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}