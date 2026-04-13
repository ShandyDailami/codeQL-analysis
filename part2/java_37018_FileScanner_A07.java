import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37018_FileScanner_A07 {
    public static void main(String[] args) {
        File root = new File("/path/to/your/directory");

        // Create the FileFilter to filter out non-text files
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.canRead() && !pathname.getName().endsWith(".txt");
            }
        };

        // Use the filter to scan the directory
        File[] files = root.listFiles(filter);

        if (files != null) {
            for (File file : files) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Add your security-sensitive operations related to A07_AuthFailure

                        // Display the line
                        System.out.println(line);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}