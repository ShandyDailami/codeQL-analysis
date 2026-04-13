import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_25696_FileScanner_A03 {
    private final String directory;

    public java_25696_FileScanner_A03(String directory) {
        this.directory = directory;
    }

    public void scan(String extension) throws FileNotFoundException {
        File dir = new File(directory);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((dir1, name) -> name.endsWith(extension));

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            System.out.println(line);
                        }
                        scanner.close();
                    }
                }
            } else {
                System.out.println("No files with extension " + extension + " found in directory " + dir.getAbsolutePath());
            }
        } else {
            System.out.println(dir.getAbsolutePath() + " is not a valid directory");
        }
    }
}