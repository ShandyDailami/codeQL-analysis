import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_02209_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // specify your directory here
        String searchString = "your_search_string"; // specify your search string here

        File directory = new File(directoryPath);
        List<String> results = findFilesWithString(directory, searchString);

        // print out results
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static List<String> findFilesWithString(File directory, String searchString) {
        List<String> results = new ArrayList<>();

        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            if (line.contains(searchString)) {
                                results.add(file.getPath());
                                break; // if the search string is found in a file, stop searching
                            }
                        }
                    }
                }
            }
        }

        return results;
    }
}