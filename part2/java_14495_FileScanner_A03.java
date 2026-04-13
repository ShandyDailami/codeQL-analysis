import java.io.File;
import java.util.Arrays;

public class java_14495_FileScanner_A03 {

    public static void main(String[] args) {
        // Define the directory and the extension
        String directoryPath = "/path/to/your/directory";
        String extension = ".txt";

        // Get a list of all files in the directory
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        // Filter files by extension
        Arrays.sort(files, (a, b) -> a.getName().toLowerCase().compareTo(b.getName().toLowerCase()));
        files = Arrays.stream(files)
                .filter(file -> file.getName().endsWith(extension))
                .toArray(size -> new File[size]);

        // Print out the paths of the files
        for (File file : files) {
            System.out.println(file.getPath());
        }
    }
}