import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04037_FileScanner_A08 {
    private static final String DIRECTORY = "/path/to/directory"; // replace with your directory

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Scanner scanner = new Scanner(file);
                        while (scanner.hasNextLine()) {
                            String line = scanner.nextLine();
                            // Process the line here
                            System.out.println(line);
                        }
                        scanner.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}