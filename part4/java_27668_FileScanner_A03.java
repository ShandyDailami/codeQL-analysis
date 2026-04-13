import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27668_FileScanner_A03 {
    private static class FileEntry {
        private String filename;
        private long size;

        public java_27668_FileScanner_A03(String filename, long size) {
            this.filename = filename;
            this.size = size;
        }

        public String getFilename() {
            return filename;
        }

        public long getSize() {
            return size;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String directory = "/path/to/directory";
        File file = new File(directory);
        if (file.isDirectory()) {
            File[] listOfFiles = file.listFiles();
            for (File f : listOfFiles) {
                if (f.isFile()) {
                    Scanner fileSizeScanner = new Scanner(f.getAbsoluteFile());
                    long lengthInBytes = f.length();
                    fileSizeScanner.useDelimiter("\\A");
                    String contents = fileSizeScanner.hasNext() ? fileSizeScanner.next() : "";
                    FileEntry fileEntry = new FileEntry(f.getName(), lengthInBytes);
                    // Do something with fileEntry...
                }
            }
        }
    }
}