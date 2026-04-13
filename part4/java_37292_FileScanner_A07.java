import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37292_FileScanner_A07 {
    public static void main(String[] args) {
        // Create a FileScanner to scan the current directory
        FileScanner scanner = new FileScanner(new File("."), true, false);

        // Scan the directory and print each file's content
        while (scanner.hasNext()) {
            File file = scanner.nextFile();
            try (Scanner fileScanner = new Scanner(file)) {
                while (fileScanner.hasNextLine()) {
                    System.out.println(fileScanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getPath());
            }
        }
    }
}

class FileScanner {
    private File[] files;
    private int index;

    public java_37292_FileScanner_A07(File directory, boolean recurse, boolean ignoreHiddenFiles) {
        this.files = directory.listFiles();
        this.index = -1;
        if (recurse) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    new FileScanner(file, recurse, ignoreHiddenFiles).scan();
                } else if (!ignoreHiddenFiles || !file.isHidden()) {
                    this.files = new File[this.files.length + 1];
                    this.files[this.files.length - 1] = file;
                }
            }
        }
    }

    public boolean hasNext() {
        return this.index + 1 < this.files.length;
    }

    public File nextFile() {
        return this.files[++this.index];
    }
}