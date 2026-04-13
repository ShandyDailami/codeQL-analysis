import java.io.File;
import java.util.Arrays;

public class java_06471_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");

        if (args.length == 1) {
            directory = new File(args[0]);
        }

        if (!directory.exists()) {
            System.out.println("No such directory: " + directory);
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Given path is not a directory: " + directory);
            return;
        }

        String[] files = directory.list();

        if (files == null) {
            System.out.println("No files or directories found in: " + directory);
            return;
        }

        Arrays.sort(files);

        for (String file : files) {
            File f = new File(directory, file);

            if (f.isFile()) {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}