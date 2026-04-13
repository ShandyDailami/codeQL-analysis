import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39061_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        String[] extensions = {".txt"};
        printFilesWithExtensions(directory, extensions);
    }

    private static void printFilesWithExtensions(File directory, String[] extensions) {
        for (String extension : extensions) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(extension));
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        printFile(file);
                    }
                }
            }
        }
    }

    private static void printFile(File file) {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}