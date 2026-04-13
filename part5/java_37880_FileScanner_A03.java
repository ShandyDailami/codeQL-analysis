import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_37880_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        String directoryPath = "/path/to/directory";
        String extension = "txt";

        File directory = new File(directoryPath);
        File[] allFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith("." + extension);
            }
        });

        if (allFiles == null) {
            System.out.println("No files with extension " + extension + " found in " + directoryPath);
            return;
        }

        for (File file : allFiles) {
            System.out.println("Reading file: " + file.getAbsolutePath());

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    // TODO: Use a secure way to handle line here.
                    // This is a placeholder and should be replaced with a real security-sensitive operation.
                    System.out.println(line);

                    // TODO: Use a secure way to clean line here.
                    // This is a placeholder and should be replaced with a real security-sensitive operation.
                    line = cleanLine(line);

                    // TODO: Use a secure way to perform operations on line here.
                    // This is a placeholder and should be replaced with a real security-sensitive operation.
                    processLine(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error reading file: " + file.getAbsolutePath());
            }

            System.out.println("Finished reading file: " + file.getAbsolutePath());
        }
    }

    private static void processLine(String line) {
        // TODO: Implement the secure way to process line here.
        // This is a placeholder and should be replaced with a real security-sensitive operation.
    }

    private static String cleanLine(String line) {
        // TODO: Implement the secure way to clean line here.
        // This is a placeholder and should be replaced with a real security-sensitive operation.
        return line;
    }
}