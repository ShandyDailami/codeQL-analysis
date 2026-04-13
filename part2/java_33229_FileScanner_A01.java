import java.io.*;

public class java_33229_FileScanner_A01 {
    private static final String DIRECTORY = "C:\\path\\to\\directory";
    private static final String FILE_EXTENSION = ".*\\.txt$";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] listOfFiles = directory.listFiles((dir, name) -> name.matches(FILE_EXTENSION));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                try {
                    readFile(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            // Perform security-sensitive operations related to A01_BrokenAccessControl
        }
        reader.close();
    }
}