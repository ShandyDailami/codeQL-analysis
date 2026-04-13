import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_36805_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "C:\\path\\to\\directory"; // replace with your directory path
        File directory = new File(directoryPath);

        // use a FileFilter to filter out directories and non-regular files
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        };

        // use the File.listFiles method to get all the .txt files in the directory
        File[] txtFiles = directory.listFiles(filter);

        if (txtFiles != null) {
            for (File file : txtFiles) {
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