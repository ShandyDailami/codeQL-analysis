import java.io.File;
import java.util.Arrays;

public class java_04827_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");

        if (args.length == 0) {
            // Scan the current directory
            scanDirectory(directory);
        } else {
            // Scan arguments passed to the program
            Arrays.stream(args).forEach(arg -> scanDirectory(new File(arg)));
        }
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursively scan directory
                    scanDirectory(file);
                } else if (file.isFile()) {
                    // Print file name
                    System.out.println(file.getName());
                }
            }
        }
    }
}