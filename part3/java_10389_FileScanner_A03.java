import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_10389_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        FileScanner fileScanner = new FileScanner();
        File directory = new File("C:\\path\\to\\your\\directory");

        fileScanner.scan(directory, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        });
    }

    public static class FileScanner {
        public void scan(File directory, FileFilter filter) throws FileNotFoundException {
            File[] list = directory.listFiles(filter);

            if (list == null) {
                System.out.println("No .txt files in the directory.");
                return;
            }

            for (File file : list) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                }
                scanner.close();
            }
        }
    }
}