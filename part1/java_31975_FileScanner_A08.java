import java.io.*;

public class java_31975_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");
        FileScanner scanner = new FileScanner(file);

        // Start scanning from the root directory
        scan(file, scanner);
    }

    private static void scan(File file, FileScanner scanner) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    scan(f, scanner);
                }
            }
        } else {
            if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png") || file.getName().endsWith(".gif") || file.getName().endsWith(".jpeg")) {
                try {
                    // You can use a secure way to read a file here.
                    FileReader reader = new FileReader(file);
                    int r;
                    while ((r = reader.read()) != -1) {
                        // You can use a secure way to print the file content here.
                        System.out.print((char) r);
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class FileScanner {
    private File file;

    public java_31975_FileScanner_A08(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}