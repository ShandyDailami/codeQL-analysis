import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04062_FileScanner_A07 {
    private static final String DIRECTORY = "/path/to/directory";
    private static final String EXTENSION = ".txt";
    private static final String SEARCH_STRING = "search_string";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        try (FileScanner scanner = new FileScanner(directory, EXTENSION)) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNext()) {
                        String content = fileScanner.nextLine();
                        if (content.contains(SEARCH_STRING)) {
                            System.out.println("File " + file.getAbsolutePath() + " contains the string " + SEARCH_STRING);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}