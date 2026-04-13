import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class java_37520_FileScanner_A03 {
    private File root;

    public java_37520_FileScanner_A03(String rootDirectory) {
        this.root = new File(rootDirectory);
    }

    public Iterator<File> iterator() {
        return new FileVisitor();
    }

    private class FileVisitor implements Iterator<File> {
        private File currentFile;

        @Override
        public boolean hasNext() {
            try {
                if (currentFile == null || !currentFile.exists()) {
                    currentFile = root.listFiles().length > 0 ? root.listFiles()[0] : null;
                } else {
                    currentFile = currentFile.getParentFile().listFiles().length > 0 ? currentFile.getParentFile().listFiles()[0] : null;
                }
            } catch (SecurityException e) {
                // Handle security exception here, if necessary
                return false;
            }
            return currentFile != null;
        }

        @Override
        public File next() {
            if (currentFile == null) {
                throw new NoSuchElementException();
            }
            return currentFile;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        VanillaFileScanner scanner = new VanillaFileScanner("/path/to/root/directory");
        for (File file : scanner) {
            // Process each file here
        }
    }
}