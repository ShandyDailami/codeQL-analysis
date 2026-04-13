import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class java_12899_FileScanner_A01 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <directory>");
            System.exit(1);
        }

        File directory = new File(args[0]);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Error: " + args[0] + " is not a directory");
            System.exit(1);
        }

        String extension = "." + Objects.requireNonNull(args[0]).substring(args[0].lastIndexOf(".") + 1);
        File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));

        if (files == null) {
            System.out.println("Error: Cannot list files in " + directory);
            System.exit(1);
        }

        for (File file : files) {
            System.out.println(file.getPath());
        }
    }
}