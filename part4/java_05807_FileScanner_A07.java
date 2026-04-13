import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_05807_FileScanner_A07 {

    private static final String DIRECTORY = "path_to_your_directory"; // replace with your directory path
    private static final String FILE_EXTENSION = "txt";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);

        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));
            if (files != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the file name to read:");
                String fileName = scanner.nextLine();

                for (File file : files) {
                    if (file.getName().equals(fileName)) {
                        try (Scanner fileScanner = new Scanner(file)) {
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                // Process the line here (e.g., check for specific auth failure)
                                System.out.println(line);
                            }
                        }
                    }
                }
            } else {
                System.out.println("Error getting files from directory: " + directory.getAbsolutePath());
            }
        } else {
            System.out.println("Error accessing directory: " + directory.getAbsolutePath());
        }
    }
}