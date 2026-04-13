import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_18363_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a file path:");
        String path = scanner.next();
        scanner.close();

        File file = new File(path);

        if (file.exists()) {
            try {
                FileScanner fileScanner = new FileScanner(file);
                fileScanner.start();
            } catch (FileNotFoundException e) {
                System.out.println("Invalid file path!");
            }
        } else {
            System.out.println("File not found!");
        }
    }

    public static class FileScanner {
        private File file;

        public java_18363_FileScanner_A03(File file) throws FileNotFoundException {
            if (!file.canRead()) {
                throw new FileNotFoundException("File is not readable");
            }
            this.file = file;
        }

        public void start() {
            System.out.println("Scanning file: " + file.getAbsolutePath());
            // TODO: Implement file scanning logic here, e.g. read file, find injection points, etc.
        }
    }
}