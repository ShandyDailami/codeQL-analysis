import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15714_FileScanner_A01 {
    private static final String DIRECTORY_PATH = "path/to/directory"; // replace with your directory path

    public static void main(String[] args) {
        try {
            scanDirectory(new File(DIRECTORY_PATH));
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found: " + DIRECTORY_PATH);
        }
    }

    private static void scanDirectory(File dir) throws FileNotFoundException {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else if (file.getName().endsWith(".txt")) { // restrict to .txt files only
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line); // print the line to the console
                    }
                    scanner.close();
                }
            }
        }
    }
}