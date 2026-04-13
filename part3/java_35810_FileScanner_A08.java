import java.io.*;

public class java_35810_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        FileScanner scanner = new FileScanner();
        scanner.startScan("C:/path/to/directory");
    }
}

class FileScanner {
    private File file;

    public java_35810_FileScanner_A08() {
        file = new File(".");
    }

    public void startScan(String path) throws IOException {
        File directory = new File(path);
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    checkFileIntegrity(file);
                } else if (file.isDirectory()) {
                    startScan(file.getPath());
                }
            }
        }
    }

    private void checkFileIntegrity(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            md.update(buffer, 0, length);
        }
        fis.close();

        byte[] digest = md.digest();

        // Replace below with your own code to check the integrity of the file
        // This is a placeholder for the A08_IntegrityFailure check
        // This code is not implemented in this example
    }
}