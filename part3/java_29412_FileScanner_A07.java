import java.io.File;
import java.util.Scanner;

public class java_29412_FileScanner_A07 {
    public static void main(String[] args) {
        File dir = new File("."); // current directory

        if (args.length == 1) {
            dir = new File(args[0]);
        } else if (args.length > 2) {
            System.out.println("Usage: ListFiles [dir]");
            return;
        }

        if (!dir.exists()) {
            System.out.println("The specified file does not exist.");
            return;
        }

        if (!dir.isDirectory()) {
            System.out.println("The specified file is not a directory.");
            return;
        }

        System.out.println("Files in " + dir.getAbsolutePath());
        String[] files = dir.list();
        if (files == null) {
            System.out.println("No files found in " + dir.getAbsolutePath());
            return;
        }

        for (String fileName : files) {
            File file = new File(dir, fileName);
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }
}