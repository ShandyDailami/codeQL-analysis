import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_23134_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        FileScanner scanner = new FileScanner();
        scanner.scanDirectory(".", new TextFileFilter());
    }

    static class FileScanner {
        public void scanDirectory(String directoryPath, FileFilter fileFilter) throws FileNotFoundException {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles(fileFilter);
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Perform security sensitive operations here, like injection prevention.
                            // This is a simple example, actual implementation could be more complex.
                            System.out.println(line);
                        }
                        scanner.close();
                    }
                }
            }
        }
    }

    static class TextFileFilter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            return pathname.isFile() && pathname.getName().endsWith(".txt");
        }
    }
}