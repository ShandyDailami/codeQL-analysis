import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03088_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.out.println("Usage: Main <directory>");
            System.exit(1);
        }

        File directory = new File(args[0]);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Error: " + args[0] + " is not a valid directory");
            System.exit(1);
        }

        FileScanner fileScanner = new FileScanner(directory);
        fileScanner.scan();
    }
}

class FileScanner {
    private File directory;

    public java_03088_FileScanner_A08(File directory) {
        this.directory = directory;
    }

    public void scan() throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getAbsolutePath());
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                }
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                scan(file);
            }
        }
    }
}