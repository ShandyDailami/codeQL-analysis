import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39653_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        FileScanner scanner = new FileScanner(new File("."), "A07_AuthFailure");
        scanner.scan();
    }

    static class FileScanner {
        private File file;
        private String searchTerm;

        public java_39653_FileScanner_A07(File file, String searchTerm) {
            this.file = file;
            this.searchTerm = searchTerm;
        }

        public void scan() throws FileNotFoundException {
            File[] listFiles = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isFile() && pathname.getName().endsWith(".txt");
                }
            });

            for (File file : listFiles) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(searchTerm)) {
                        System.out.println("Found the term in the file: " + file.getPath());
                    }
                }
                scanner.close();
            }
        }
    }
}