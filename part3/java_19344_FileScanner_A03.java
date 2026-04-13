import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class java_19344_FileScanner_A03 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java TextFileScanner directory text");
            System.exit(0);
        }

        String directory = args[0];
        String extension = args[1];

        File initialDirectory = new File(directory);

        FileFilter filter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(extension);
            }
        };

        System.out.println("Files with extension " + extension + ":");
        printFiles(initialDirectory.listFiles(filter));
    }

    private static void printFiles(File[] files) {
        if (files == null) return;

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else {
                printFiles(file.listFiles());
            }
        }
    }
}