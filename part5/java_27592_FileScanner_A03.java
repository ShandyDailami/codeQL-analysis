import java.io.File;
import java.util.Arrays;

public class java_27592_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/your/directory"; // replace with your directory path
        String fileExtension = "txt"; // file extension you want to scan

        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (txtFiles != null) {
            Arrays.stream(txtFiles).forEach(Main::processFile);
        }
    }

    private static void processFile(File file) {
        // this method can be replaced with your own file processing logic
        // for example, you might print the file name to the console or read the content
        System.out.println("Processing file: " + file.getName());
    }
}