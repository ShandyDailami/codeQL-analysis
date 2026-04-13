import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33197_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";
        File directory = new File(directoryPath);

        FileFilter textFilesFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.canRead() && !pathname.getName().endsWith(".txt");
            }
        };

        File[] allTextFiles = directory.listFiles(textFilesFilter);

        if (allTextFiles != null) {
            for (File textFile : allTextFiles) {
                Scanner scanner = new Scanner(textFile);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    // Process the line here
                }
                scanner.close();
            }
        }
    }
}