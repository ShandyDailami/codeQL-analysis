import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32131_FileScanner_A07 {

    private static final String DIRECTORY = "path/to/directory";
    private static final String EXTENSION = "txt";
    private static final String FILTER = "filter";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(EXTENSION));

            if (files != null) {
                for (File file : files) {
                    try (Scanner scanner = new Scanner(file)) {
                        if (scanner.hasNextLine()) {
                            String line = scanner.nextLine();

                            if (!line.contains(FILTER)) {
                                System.out.println(file.getPath());
                            }
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("No files found with extension: " + EXTENSION);
            }
        } else {
            System.out.println("Directory not found");
        }
    }
}