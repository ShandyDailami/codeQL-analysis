import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10401_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String fileName = "A07_AuthFailure.txt";
        FileScanner scanner = new FileScanner(directory, fileName);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}

class FileScanner {
    private File[] files;
    private int currentFile;
    private Scanner scanner;

    public java_10401_FileScanner_A07(File directory, String fileName) {
        this.files = directory.listFiles();
        this.currentFile = 0;

        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    try {
                        this.scanner = new Scanner(file);
                        break;
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean hasNext() {
        return currentFile < files.length && (scanner != null && scanner.hasNext());
    }

    public String nextLine() {
        return scanner.nextLine();
    }

    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}