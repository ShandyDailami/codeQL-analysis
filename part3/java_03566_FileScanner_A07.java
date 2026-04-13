import java.io.File;
import java.util.Arrays;

public class java_03566_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");

        if (args.length == 1 && args[0].equals("-r")) {
            directory = new File(args[0]);
        } else {
            System.out.printf("Reading all text files in %s%n", directory);
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory()) {
                    System.out.printf("File: %s%n", file.getAbsolutePath());
                }
            }
        }
    }
}