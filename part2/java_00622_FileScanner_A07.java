import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00622_FileScanner_A07 {
    private static final String DIRECTORY_TO_SCAN = "/path/to/directory"; // replace with your directory
    private static final String SEARCH_STRING = "A07_AuthFailure";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_TO_SCAN);
        searchForFile(directory);
    }

    private static void searchForFile(File directory) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains(SEARCH_STRING)) {
                                System.out.println("File containing '" + SEARCH_STRING + "' found: " + file.getAbsolutePath());
                                scanner.close();
                                return;
                            }
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (file.isDirectory()) {
                    searchForFile(file);
                }
            }
        }
    }
}