import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_33451_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = args[0];
        String fileExtension = args[1];
        String searchString = args[2];

        File directory = new File(directoryPath);

        FileFilter fileFilter = (File file) -> file.getName().endsWith(fileExtension);

        File[] files = directory.listFiles(fileFilter);

        if (files != null) {
            for (File file : files) {
                if (file.canRead()) {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.contains(searchString)) {
                            System.out.println("File: " + file.getAbsolutePath());
                            System.out.println("Line: " + line);
                            System.out.println("Content: " + line);
                            System.out.println();
                        }
                    }
                    scanner.close();
                }
            }
        }
    }
}