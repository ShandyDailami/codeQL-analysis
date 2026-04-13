import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21300_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");

        // create a FileFilter that will filter out .java files
        FileFilter javaFiles = new FileFilter() {
            public boolean accept(File pathname) {
                // accept only .java files
                return pathname.getName().endsWith(".java");
            }
        };

        // use a FileFilter for scanning files
        File[] javaFiles = directory.listFiles(javaFiles);
        if (javaFiles != null) {
            for (File file : javaFiles) {
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}