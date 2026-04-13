import java.io.*;

public class java_05889_FileScanner_A03 {
    private static final String DIRECTORY = "C:\\path_to_directory";
    private static final String FILE_EXTENSION = ".*\\.txt";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] txtFiles = directory.listFiles((dir, name) -> name.matches(FILE_EXTENSION));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(txtFile))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Process the line as needed for security-sensitive operations
                    }
                } catch (IOException e) {
                    System.out.println("Error processing file: " + txtFile.getName());
                    e.printStackTrace();
                }
            }
        }
    }
}