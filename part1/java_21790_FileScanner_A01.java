import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;

public class java_21790_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        // Create a FileScanner to scan the current directory
        FileScanner scanner = new FileScanner();

        // Use the scanner to get an Iterator over the current directory
        Iterator<File> iterator = scanner.getFilesInDirectory(new File("."));

        // Use a Scanner to read the contents of each file
        while (iterator.hasNext()) {
            File file = iterator.next();
            Scanner fileScanner = new Scanner(new FileReader(file));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
            fileScanner.close();
        }
    }
}

class FileScanner {
    public Iterator<File> getFilesInDirectory(File dir) {
        return new FileIterator(dir);
    }
}

class FileIterator implements Iterator<File> {
    private File[] files;
    private int index;

    public java_21790_FileScanner_A01(File dir) {
        files = dir.listFiles();
        index = 0;
    }

    public boolean hasNext() {
        return index < files.length;
    }

    public File next() {
        return files[index++];
    }
}