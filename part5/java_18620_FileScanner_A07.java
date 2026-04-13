import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_18620_FileScanner_A07 {

    private static final String TEXT_EXTENSION = ".txt";
    private static final String AUTH_FAILURE = "A07_AuthFailure";

    public static void main(String[] args) {
        String directoryPath = "path_to_directory"; // replace with actual directory path
        scanDirectory(directoryPath);
    }

    private static void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(TEXT_EXTENSION));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                try {
                    if (handleAuthFailure(txtFile)) {
                        System.out.println("Authentication failure detected in: " + txtFile.getAbsolutePath());
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean handleAuthFailure(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(AUTH_FAILURE)) {
                return true;
            }
        }
        scanner.close();
        return false;
    }
}