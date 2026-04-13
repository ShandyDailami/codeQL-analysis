import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_12591_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File(".");
        String[] extensions = {".txt"};
        scanDirectory(directory, extensions);
    }

    private static void scanDirectory(File directory, String[] extensions) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file, extensions);
                } else {
                    if (isFileOfInterest(file, extensions)) {
                        try {
                            Scanner scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                System.out.println(line);
                            }
                            scanner.close();
                        } catch (FileNotFoundException e) {
                            System.out.println("Error reading file: " + file.getPath());
                        }
                    }
                }
            }
        }
    }

    private static boolean isFileOfInterest(File file, String[] extensions) {
        for (String extension : extensions) {
            if (file.getName().toLowerCase().endsWith(extension)) {
                return true;
            }
        }
        return false;
    }
}