import java.io.*;

public class java_35237_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File(".");

        try (FileScanner scanner = new FileScanner(file)) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                System.out.println("File: " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FileScanner implements AutoCloseable {
    private final File file;
    private FileInputStream fis;

    public java_35237_FileScanner_A01(File file) throws IOException {
        this.file = file;
        this.fis = new FileInputStream(file);
    }

    public boolean hasNext() {
        try {
            return fis.read() != -1;
        } catch (IOException e) {
            return false;
        }
    }

    public File nextFile() throws IOException {
        return new File(fis.readLink());
    }

    @Override
    public void close() throws Exception {
        if (fis != null) {
            fis.close();
        }
    }
}