import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_37843_FileScanner_A08 {
    private static final String DIRECTORY = "C:\\temp";
    private static final String EXTENSION = "txt";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        File[] files = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("." + EXTENSION);
            }
        });

        if (files != null) {
            Arrays.sort(files, String.CASE_INSENSITIVE_ORDER);

            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("No files with the extension " + EXTENSION + " found in " + DIRECTORY);
        }
    }
}