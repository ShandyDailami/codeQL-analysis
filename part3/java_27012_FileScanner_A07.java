import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_27012_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";

        File directory = new File(directoryPath);

        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        };

        fileScanner(directory, fileFilter);
    }

    private static void fileScanner(File directory, FileFilter fileFilter) throws FileNotFoundException {
        File[] allFiles = directory.listFiles(fileFilter);

        if (allFiles != null) {
            for (File file : allFiles) {
                if (file.isFile()) {
                    Scanner scanner = new Scanner(file);

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }

                    scanner.close();
                }
            }
        }
    }
}