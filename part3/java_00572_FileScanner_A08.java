import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_00572_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // replace with actual directory path
        File directory = new File(directoryPath);

        FileFilter textFilesFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        File[] textFiles = directory.listFiles(textFilesFilter);

        if (textFiles != null) {
            for (File textFile : textFiles) {
                Scanner scanner = new Scanner(textFile);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            }
        }
    }
}