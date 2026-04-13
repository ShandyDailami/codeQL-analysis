import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15895_FileScanner_A07 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // replace with your directory path
        String sensitiveOperation = "AuthFailure"; // replace with your sensitive operation

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && isFileSafe(file, sensitiveOperation)) {
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // process file line
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static boolean isFileSafe(File file, String sensitiveOperation) {
        // implement your own file checking logic here
        // return true if the file is safe, false otherwise
    }
}