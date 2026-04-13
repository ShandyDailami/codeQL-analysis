import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_05176_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/your/directory";
        String integrityFailurePrefix = "A08_IntegrityFailure";

        File directory = new File(directoryPath);
        searchDirectory(directory, integrityFailurePrefix);
    }

    private static void searchDirectory(File directory, String integrityFailurePrefix) throws FileNotFoundException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().startsWith(integrityFailurePrefix)) {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // handle the line here
                        }
                        scanner.close();
                    }
                } else if (file.isDirectory()) {
                    searchDirectory(file, integrityFailurePrefix);
                }
            }
        }
    }
}