import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_35306_FileScanner_A07 {

    // This is a very simple search for a string in a file. 
    // In a real-world scenario, you would need to use more sophisticated techniques
    // like regular expressions or tokenization/parsing.
    private static final String SEARCH_STRING = "AuthFailure";

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "path_to_directory";  // replace with your directory path
        File directory = new File(directoryPath);
        File[] matchingFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        
        for (File file : matchingFiles) {
            if (file.getName().contains(SEARCH_STRING)) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.contains(SEARCH_STRING)) {
                        System.out.println("Found in file: " + file.getAbsolutePath());
                    }
                }
                scanner.close();
            }
        }
    }
}