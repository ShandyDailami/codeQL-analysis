import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_15694_FileScanner_A07 {
    private static final String DIRECTORY_PATH = "/path/to/directory";
    private static final String FILE_EXTENSION = "ext";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);

        if (directory.exists()) {
            File[] files = directory.listFiles(file -> file.getName().endsWith(FILE_EXTENSION));

            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        try {
                            Scanner scanner = new Scanner(file);
                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                // Here you can add code for authentication
                                // For example, check for 'auth' in the line
                                if (line.contains("auth")) {
                                    System.out.println("Found authentication failure on line: " + line);
                                }
                            }
                            scanner.close();
                        } catch (Exception e) {
                            System.out.println("Error processing file: " + file.getName());
                        }
                    }
                });
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}