import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37471_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String fileExtension = ".*.txt";

        File directory = new File(directoryPath);
        File[] listOfFiles = directory.listFiles((dir, name) -> name.matches(fileExtension));

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (isLineIntegrityFailure(line)) {
                            System.out.println("Integrity failure detected in line: " + line + " in file: " + file.getName());
                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isLineIntegrityFailure(String line) {
        // Implementation of the logic to detect integrity failures
        // This could be a regex match, a specific error code, etc.
        // For simplicity, let's assume all lines that contain a specific word are integrity failures
        return line.contains("integrity");
    }
}