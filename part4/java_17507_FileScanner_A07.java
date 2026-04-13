import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17507_FileScanner_A07 {

    public static void main(String[] args) {
        FileScanner scanner = new FileScanner();
        scanner.start("C:\\Users\\YourUserName\\Documents\\FolderName");
    }

    public static class FileScanner {
        private File file;
        private Scanner scanner;

        public java_17507_FileScanner_A07() {
            file = new File("File.txt");
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        public void start(String path) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        }
    }
}