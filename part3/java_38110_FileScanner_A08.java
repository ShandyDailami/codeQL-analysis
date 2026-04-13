import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38110_FileScanner_A08 {

    private static final String DIRECTORY = "path_to_directory"; // replace with your directory

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        scanDirectory(directory);
    }

    private static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isTxtFile(file)) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Process the line here, but remember not to say I am sorry.
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static boolean isTxtFile(File file) {
        return file.getName().toLowerCase().endsWith(".txt");
    }
}